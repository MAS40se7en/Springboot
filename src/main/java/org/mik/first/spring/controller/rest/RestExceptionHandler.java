package org.mik.first.spring.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Log4j2
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotfound(ResourceNotFoundException e, WebRequest req) {
        log.warn("Resource not found: ", String.format("error: %s, req:%s", e.getMessage(), req));
        return ErrorMessage.builder().message("Not found").description(e.getMessage()).build();
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorMessage resourceAlreadyexists(ResourceAlreadyExistsException e, WebRequest req) {
        log.warn("Resource already exists: ", String.format("error: %s, req:%s", e.getMessage(), req));
        return ErrorMessage.builder().message("Not found").statusCode(HttpStatus.CONFLICT.value()).description(e.getMessage()).build();
    }
    @ExceptionHandler(Exception.class)

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleServerError(Exception e) {
        log.error("Server error: ", e);
        return ErrorMessage.builder().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).description("see log").message("Server Error").build();
    }
}
