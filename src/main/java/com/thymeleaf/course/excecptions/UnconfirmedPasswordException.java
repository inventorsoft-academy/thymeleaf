package com.thymeleaf.course.excecptions;

public class UnconfirmedPasswordException extends RuntimeException {
    public UnconfirmedPasswordException(String message) {
        super(message);
    }
}
