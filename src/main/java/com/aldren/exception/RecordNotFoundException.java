package com.aldren.exception;

import lombok.Getter;

@Getter
public class RecordNotFoundException extends Exception {

    private String messeage;

    public RecordNotFoundException(String message) {
        this.messeage = message;
    }

}
