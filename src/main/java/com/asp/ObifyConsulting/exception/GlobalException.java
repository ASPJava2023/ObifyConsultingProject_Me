package com.asp.ObifyConsulting.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException; // ✅ Corrected import
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalException {

    // ✅ Handles validation errors on method arguments (like @Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errorMap.put(error.getField(), error.getDefaultMessage())
        );
        log.error("Validation Error: {}", errorMap);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }

    // ✅ Handles custom exception
    @ExceptionHandler(PropertyNotFoundExceptionCustom.class)
    public ResponseEntity<Map<String, String>> handlePropertyNotFound(PropertyNotFoundExceptionCustom ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", ex.getMessage());
        log.error("Property Not Found: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }

    // ✅ Handles bean validation constraint violations
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, String> errorMap = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errorMap.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        log.error("Constraint Violation: {}", errorMap);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }
}
