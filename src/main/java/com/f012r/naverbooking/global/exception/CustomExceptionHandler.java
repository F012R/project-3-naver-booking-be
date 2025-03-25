package com.f012r.naverbooking.global.exception;

import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.common.ResponseDTO;
import com.f012r.naverbooking.global.exception.custom.*;
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

    @ExceptionHandler(ImageNotFoundException.class)
    public ResponseEntity<ResponseDTO<Void>> handleImageNotFoundException(ImageNotFoundException e) {
        return ResponseEntity
                .status(ResponseCode.ImageNotFoundException.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.ImageNotFoundException, null));
    }

    @ExceptionHandler(InvalidReservationException.class)
    public ResponseEntity<ResponseDTO<Void>> handleInvalidReservationException(InvalidReservationException e) {
        return ResponseEntity
                .status(ResponseCode.InvalidReservationException.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.InvalidReservationException, null));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseDTO<Void>> handleProductNotFoundException(ProductNotFoundException e) {
        return ResponseEntity
                .status(ResponseCode.ProductNotFoundException.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.ProductNotFoundException, null));
    }

    @ExceptionHandler(ReservationAlreadyCancelledException.class)
    public ResponseEntity<ResponseDTO<Void>> ReservationAlreadyCancelledException(ReservationAlreadyCancelledException e) {
        return ResponseEntity
                .status(ResponseCode.ReservationAlreadyCancelledException.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.ReservationAlreadyCancelledException, null));
    }

    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<ResponseDTO<Void>> ReservationNotFoundException(ReservationNotFoundException e) {
        return ResponseEntity
                .status(ResponseCode.ReservationNotFoundException.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.ReservationNotFoundException, null));
    }

}
