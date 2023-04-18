package com.tekgs.nextgen.ctrlintelligence.view.error;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ErrorViewCalibrator extends Calibrator {
    private static final String description = "'Error Page' View";
    private final ErrorViewExpected expected;
    private final ErrorView actual;

    private ErrorViewCalibrator(ErrorViewExpected expected, ErrorView actual) {
        super(description, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ErrorViewCalibrator getInstance(ErrorViewExpected expected, ErrorView actual) {
        return new ErrorViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
       verify("'Error View' message",expected.getErrorMessage(), actual.getErrorMessage());
    }
}
