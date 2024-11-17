package com.example.handmade.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private int code;
    private String error;
    private String message;
    private Map<String, String> fields;

    public ErrorResponse(HttpStatus httpStatus) {
        this(httpStatus, null);
    }

    public ErrorResponse(HttpStatus httpStatus, String message) {
        this(httpStatus.value(), httpStatus.getReasonPhrase(), message, null);
    }

    public ErrorResponse(HttpStatus httpStatus, Map<String, String> fields, String message) {
        this(httpStatus.value(), httpStatus.getReasonPhrase(), message, fields);
    }
}