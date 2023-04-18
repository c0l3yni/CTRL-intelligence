package com.tekgs.nextgen.ctrlintelligence.view.error;

public class ErrorViewExpected implements ErrorViewCalibratable {
    private final String errorMessage;

    private ErrorViewExpected(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static ErrorViewExpected getInstance() {
        return new ErrorViewExpected("You attempted to enter a high-security URL, and were caught. Please try a different URL!");
    }

    public static ErrorViewExpected getInstance(String errorMessage) {
        return new ErrorViewExpected(errorMessage);
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
