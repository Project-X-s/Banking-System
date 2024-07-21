package com.example.banking_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking_system.Client.NotificationClient;
import com.example.banking_system.Exception.SystemException;
import com.example.banking_system.Module.Transition;

@Service
public class NotificationService {
    
    @Autowired
    NotificationClient notificationClient;

    public void sendNotification(Transition transition) {
        try {
            notificationClient.sendNotification(transition);
        } catch (Exception e) {
            throw new SystemException();
        }
    }
}
