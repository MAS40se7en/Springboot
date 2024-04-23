package org.mik.first.spring.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private String message;
    private String description;
    private LocalDateTime tstamp=LocalDateTime.now();
}
