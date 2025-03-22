package com.f012r.naverbooking.global.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(HttpStatus.OK, "OK"),

    InvalidEmailException(HttpStatus.BAD_REQUEST, "Invalid email format");
    ;

    private final HttpStatus status;
    private final String message;
}
