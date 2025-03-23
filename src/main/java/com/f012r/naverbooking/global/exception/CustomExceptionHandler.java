package com.f012r.naverbooking.global.exception;

import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.common.ResponseDTO;
import com.f012r.naverbooking.global.exception.custom.EmptyEmailException;
import com.f012r.naverbooking.global.exception.custom.InvalidEmailException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<ResponseDTO<Void>> handleInvalidEmailException(InvalidEmailException e) {
        return ResponseEntity
                .status(ResponseCode.InvalidEmailException.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.InvalidEmailException, null));
    }

    @ExceptionHandler(EmptyEmailException.class)
    public ResponseEntity<ResponseDTO<Void>> handleInvalidEmailException(EmptyEmailException e) {
        return ResponseEntity
                .status(ResponseCode.EmptyEmailException.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.EmptyEmailException, null));
    }
}
