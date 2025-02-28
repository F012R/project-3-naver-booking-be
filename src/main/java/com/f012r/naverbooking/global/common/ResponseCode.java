package com.f012r.naverbooking.global.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(HttpStatus.OK, "OK"),

    ImageNotFoundException(HttpStatus.NOT_FOUND, "Image Not Found"),
    ;

    private final HttpStatus status;
    private final String message;
}
