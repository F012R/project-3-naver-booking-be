package com.f012r.naverbooking.global.util;

import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.exception.custom.EmptyEmailException;
import com.f012r.naverbooking.global.exception.custom.InvalidEmailException;

import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    private EmailValidator() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new EmptyEmailException(ResponseCode.EmptyEmailException);
        } else if (!(emailPattern.matcher(email).matches())) {
            throw new InvalidEmailException(ResponseCode.InvalidEmailException);
        }
    }
}
