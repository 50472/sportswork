package com.sportswork.sportswork.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler
    public void DefaultExceptionHandler(Exception e) {
        log.error("msg:", e);
    }
}
