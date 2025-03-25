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

    InvalidReservationException(HttpStatus.BAD_REQUEST, "Invalid reservation request"),

    ProductNotFoundException(HttpStatus.NOT_FOUND, "Product Not Found"),

    ReservationNotFoundException(HttpStatus.NOT_FOUND, "Reservation Not Found"),

    ReservationAlreadyCancelledException(HttpStatus.BAD_REQUEST, "Reservation Already Cancelled");

    private final HttpStatus status;
    private final String message;
}
