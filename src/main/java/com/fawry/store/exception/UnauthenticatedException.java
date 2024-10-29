package com.fawry.store.exception;

public class UnauthenticatedException extends RuntimeException {
    public UnauthenticatedException() {
        super("Unauthenticated");
    }
}
