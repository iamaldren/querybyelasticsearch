package com.aldren.exception;

import lombok.Getter;

@Getter
public class BadRequetException extends Exception {

    private String messeage;

    public BadRequetException(String message) {
        this.messeage = message;
    }

}
