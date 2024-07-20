package com.example.banking_system.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Response<T> {
    private T data;
    private String errorMessage;
}
