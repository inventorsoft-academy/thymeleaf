package com.thymeleaf.course.exception;

public class ConfirmPasswordException extends RuntimeException {

    public ConfirmPasswordException() {
        super("Confirm password does not match");
    }

}