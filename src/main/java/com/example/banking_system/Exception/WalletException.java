package com.example.banking_system.Exception;

import org.springframework.http.ProblemDetail;

public class WalletException extends SystemException {

    public String detail;

    public WalletException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail pd = ProblemDetail.forStatus(422);
        pd.setTitle("Dados da Wallet já existe");
        pd.setDetail(detail);
        return pd;
    }
    
}
