package com.pulsequeue.domain;

public class InvalidJobStateTransitionException extends RuntimeException {

    public InvalidJobStateTransitionException(String message) {
        super(message);
    }
}

