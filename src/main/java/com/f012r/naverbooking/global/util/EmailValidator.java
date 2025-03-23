package com.f012r.naverbooking.global.util;

import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    private EmailValidator() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static boolean isValid(String email) {
        return email != null && !email.isEmpty() && emailPattern.matcher(email).matches();
    }
}
