package com.f012r.naverbooking.global.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(HttpStatus.OK, "OK"),

    InvalidEmailException(HttpStatus.BAD_REQUEST, "Invalid email format"),

    EmptyEmailException(HttpStatus.BAD_REQUEST, "Email must not be empty"),

    ImageNotFoundException(HttpStatus.NOT_FOUND, "Image Not Found"),

    ProductNotFoundException(HttpStatus.NOT_FOUND, "Product Not Found"),

    InvalidDisplayInfoIdException(HttpStatus.BAD_REQUEST, "Invalid Displayinfo Id"),

    InvalidReservationException(HttpStatus.BAD_REQUEST, "Invalid reservation request"),

    ReservationNotFoundException(HttpStatus.NOT_FOUND, "Reservation Not Found"),

    ReservationAlreadyCancelledException(HttpStatus.BAD_REQUEST, "Reservation Already Cancelled"),

    InvalidScoreException(HttpStatus.BAD_REQUEST, "Invalid score, must be between 0 and 5"),

    EmptyCommentException(HttpStatus.BAD_REQUEST, "Comment cannot be empty");

    private final HttpStatus status;
    private final String message;
}
