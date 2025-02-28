package com.f012r.naverbooking.global.common;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"status", "message", "data"})
public class ResponseDTO<T> {

    private final Integer status;
    private final String message;
    private final T data;

    public ResponseDTO(ResponseCode responseCode, T data) {
        this.status = responseCode.getStatus().value();
        this.message = responseCode.getMessage();
        this.data = data;
    }
}
