package com.f012r.naverbooking.global.exception;

import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.common.ResponseDTO;
import com.f012r.naverbooking.global.exception.custom.InvalidEmailException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<ResponseDTO<ResponseCode>> handleInvalidEmailException(InvalidEmailException e) {
        return ResponseEntity
                .status(ResponseCode.InvalidEmailException.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.InvalidEmailException, null));
    }
}
