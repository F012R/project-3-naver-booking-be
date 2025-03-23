package com.f012r.naverbooking.global.exception;

import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.common.ResponseDTO;
import com.f012r.naverbooking.global.exception.custom.ImageNotFoundException;
import com.f012r.naverbooking.global.exception.custom.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ImageNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleImageNotFoundException(ImageNotFoundException e) {
        return ResponseEntity
                .status(ResponseCode.ImageNotFoundException.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.ImageNotFoundException, null));
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseDTO<Void>> handleProductNotFoundException(ProductNotFoundException e) {
        return ResponseEntity
                .status(ResponseCode.ProductNotFoundException.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.ProductNotFoundException, null));
    }

}
