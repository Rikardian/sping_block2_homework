package ru.ibs.homework.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity handle() {

        return ResponseEntity.status(500).body("Необходимо ввести ID!");

    }
}
