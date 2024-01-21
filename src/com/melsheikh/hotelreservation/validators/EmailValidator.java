package com.melsheikh.hotelreservation.validators;

import com.melsheikh.hotelreservation.constants.Constants;

import java.util.regex.Pattern;

public class EmailValidator implements Validator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(Constants.EMAIL_REGEX);
    private static EmailValidator instance;

    private EmailValidator() {

    }

    public static EmailValidator getInstance() {
        if (instance == null) {
            instance = new EmailValidator();
        }

        return instance;
    }

    @Override
    public boolean isValid(String input) {
        if (input == null) {
            return false;
        }

        return EMAIL_PATTERN.matcher(input).matches();
    }
}
