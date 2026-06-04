package com.example.auth.core;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*d

@Since 5/25/2026
@Author qle20

*/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<String> handleRuntimeException(RuntimeException ex) {
        return ApiResponse.<String>builder()
                .code(500)
                .message("An unexpected error occurred: " + ex.getMessage())
                .data(null)
                .build();
    }
}
