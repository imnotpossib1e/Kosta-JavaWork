package com.ws07.exception;

public class BalanceLackException extends Exception {

    public BalanceLackException() {
        super("잔액을 확인하세요");
    }

    public BalanceLackException(String message) {
        super(message);
    }
}
