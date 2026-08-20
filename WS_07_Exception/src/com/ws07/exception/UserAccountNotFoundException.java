package com.ws07.exception;

public class UserAccountNotFoundException extends Exception {

    public UserAccountNotFoundException() {
        super("회원정보를 찾을 수 없습니다.");
    }

    public UserAccountNotFoundException(String message) {
        super(message);
    }
}
