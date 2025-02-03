package com.RohitBisht.Project.UberProject.UberApp.Advices;

import com.RohitBisht.Project.UberProject.UberApp.Exceptions.ResourceNotFoundException;
import com.RohitBisht.Project.UberProject.UberApp.Exceptions.RuntimeConflictException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return buildErrorResponse(apiError);
    }

    @ExceptionHandler(RuntimeConflictException.class)
    public ResponseEntity<ApiResponse<?>> handleRuntimeConflictException(ResourceNotFoundException exception) {
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.CONFLICT)
                .build();

        return buildErrorResponse(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception) {
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();

        return buildErrorResponse(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInputValidationError(MethodArgumentNotValidException e) {
        List<String> Error = e
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Input Validation Failed")
                .build();

        return buildErrorResponse(apiError);
    }

    public ResponseEntity<ApiResponse<?>> buildErrorResponse(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
    }
}
