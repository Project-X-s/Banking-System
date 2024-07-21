package com.example.banking_system.Service;

import java.util.concurrent.CompletableFuture;

import javax.sound.midi.SysexMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking_system.DTO.TransitionRequestDTO;
import com.example.banking_system.Exception.NotFoundException;
import com.example.banking_system.Exception.SystemException;
import com.example.banking_system.Module.Transition;
import com.example.banking_system.Module.Wallet;
import com.example.banking_system.Repository.TransitionRespository;
import com.example.banking_system.Repository.WalletRepository;

import jakarta.transaction.Transactional;

@Service
public class TransitionService {
    
    @Autowired
    TransitionRespository transitionRespository;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    NotificationService notificationService;
    
    @Autowired
    AuthorizarionService authorizarionService;

    @Transactional // Rollback, caso algo de errado tudo voltará para o estado original
    public Transition transferencia(TransitionRequestDTO DTO) {
        
        Wallet sender = walletRepository.findById(DTO.wPayer())
            .orElseThrow(() -> new NotFoundException());

        Wallet receiver = walletRepository.findById(DTO.wReceiver())
            .orElseThrow(() -> new NotFoundException());

        validadeTransfer(DTO, sender);
        
        sender.debit(DTO.value());
        receiver.credit(DTO.value());

        Transition transition = new Transition(sender, receiver, DTO.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        Transition transitionResult = transitionRespository.save(transition);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transitionResult));

        return transition;
    }


    private void validadeTransfer(TransitionRequestDTO transitionRequestDTO, Wallet sender) {
        if (!sender.isTransferAllowedForWalletType()) {
            throw new SystemException().error("Não é permitido a transferencia!!");
        }

        if (!sender.isBalancerEqualOrGreaterThen(transitionRequestDTO.value())) {
            throw new SystemException().error("Valor a pagar é maior que o total da conta");
        }

        if (!authorizarionService.isAuthorized(transitionRequestDTO)) {
            throw new SystemException().error("Não está autorizado");
        }
    }
}
