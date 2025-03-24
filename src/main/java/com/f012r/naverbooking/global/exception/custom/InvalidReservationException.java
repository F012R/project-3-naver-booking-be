package com.f012r.naverbooking.global.exception.custom;

import com.f012r.naverbooking.global.common.ResponseCode;
import lombok.Getter;

@Getter
public class InvalidReservationException extends RuntimeException {
    private final ResponseCode responseCode;

    public InvalidReservationException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }
}