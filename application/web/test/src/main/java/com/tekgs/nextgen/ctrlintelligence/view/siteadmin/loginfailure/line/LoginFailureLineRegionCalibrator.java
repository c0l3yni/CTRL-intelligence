package com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.line;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class LoginFailureLineRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Failure Date' region";
    private final LoginFailureLineRegionCalibratable actual;
    private final LoginFailureLineRegionCalibratable expected;

    private LoginFailureLineRegionCalibrator(LoginFailureLineRegionCalibratable expected, LoginFailureLineRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static LoginFailureLineRegionCalibrator getInstance(LoginFailureLineRegionCalibratable expected, LoginFailureLineRegionCalibratable actual) {
        return new LoginFailureLineRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Date", expected.getDate(), actual.getDate());
        verify("Count", expected.getCount(), actual.getCount());
        verify("'Date' label", expected.getFailureDateLabel(), actual.getFailureDateLabel());
    }
}
