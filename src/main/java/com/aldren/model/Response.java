package com.aldren.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Response {

    private String timestamp;

    private int status;

    private String description;

    private String message;

    private String path;

}
