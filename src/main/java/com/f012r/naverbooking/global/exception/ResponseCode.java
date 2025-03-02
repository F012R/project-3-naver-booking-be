package com.f012r.naverbooking.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(HttpStatus.OK, "OK"),
    ;

    private final HttpStatus status;
    private final String message;
}
