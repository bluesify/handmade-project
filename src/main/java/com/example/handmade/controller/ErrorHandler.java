package com.example.handmade.controller;

import com.example.handmade.exception.AppException;
import com.example.handmade.exception.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ErrorHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException ex) {
        HttpStatus httpStatus = ex.getHttpStatus();

        String message = messageSource.getMessage(ex.getErrorMessage().getCode(),
                ex.getErrorParams(), Locale.getDefault());

        ErrorResponse ErrorResponse = new ErrorResponse(httpStatus, message);

        return new ResponseEntity<>(ErrorResponse, httpStatus);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorResponse> handleMissingRequestHeaderException(MissingRequestHeaderException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponse ErrorResponse = new ErrorResponse(httpStatus, ex.getMessage());
        return new ResponseEntity<>(ErrorResponse, httpStatus);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException ex) {
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        ErrorResponse ErrorResponse = new ErrorResponse(httpStatus, ex.getMessage());
        return new ResponseEntity<>(ErrorResponse, httpStatus);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException ex) {
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
        ErrorResponse ErrorResponse = new ErrorResponse(httpStatus, ex.getMessage());
        return new ResponseEntity<>(ErrorResponse, httpStatus);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponse ErrorResponse = new ErrorResponse(httpStatus, ex.getMessage());
        return ResponseEntity.status(httpStatus).body(ErrorResponse);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchEx(MethodArgumentTypeMismatchException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponse ErrorResponse = new ErrorResponse(httpStatus, ex.getMessage());
        return ResponseEntity.status(httpStatus).body(ErrorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse ErrorResponse = new ErrorResponse(httpStatus, ex.getMessage());
        return new ResponseEntity<>(ErrorResponse, httpStatus);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        Map<String, String> fields = new HashMap<>();
        ex.getConstraintViolations().forEach(violation ->
                fields.put(violation.getPropertyPath().toString(), violation.getMessage()));

        ErrorResponse ErrorResponse = new ErrorResponse(httpStatus, fields, "Some fields are invalid");

        return new ResponseEntity<>(ErrorResponse, httpStatus);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ErrorResponse ErrorResponse = new ErrorResponse(httpStatus);

        BindingResult bindingResult = ex.getBindingResult();
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> fields = new HashMap<>();
            bindingResult.getFieldErrors().forEach(field ->
                    fields.put(field.getField(), field.getDefaultMessage()));

            ErrorResponse.setFields(fields);
            ErrorResponse.setMessage("Some fields are invalid");
        } else if (bindingResult.getGlobalError() != null) {
            ErrorResponse.setMessage(bindingResult.getGlobalError().getDefaultMessage());
        }

        return new ResponseEntity<>(ErrorResponse, httpStatus);
    }

}
