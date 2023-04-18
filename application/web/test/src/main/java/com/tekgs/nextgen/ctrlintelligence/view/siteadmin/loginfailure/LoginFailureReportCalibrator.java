package com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.line.LoginFailureLineRegionCalibratable;
import com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.line.LoginFailureLineRegionCalibrator;

import java.util.ArrayList;
import java.util.List;

public class LoginFailureReportCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Failure Report' region";
    private final LoginFailureReportExpected expected;
    private final LoginFailureReport actual;

    private LoginFailureReportCalibrator(LoginFailureReportExpected expected, LoginFailureReport actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
        List<LoginFailureLineRegionCalibratable> actualFailureDates = new ArrayList<>(actual.getFailureLines());
        List<LoginFailureLineRegionCalibratable> expectedFailureDates = expected.getFailureLines();
        addExpectedFailureDateCalibrators(actualFailureDates, expectedFailureDates);
        addUnexpectedFailureDateCalibrators(actualFailureDates);
    }

    public static LoginFailureReportCalibrator getInstance(LoginFailureReportExpected expected, LoginFailureReport actual) {
        return new LoginFailureReportCalibrator(expected, actual);
    }

    private void addUnexpectedFailureDateCalibrators(List<LoginFailureLineRegionCalibratable> actualFailureDates) {
        for (LoginFailureLineRegionCalibratable unexpected : actualFailureDates) {
            addChildCalibrator(LoginFailureLineRegionCalibrator.getInstance(null, unexpected));
        }
    }

    private void addExpectedFailureDateCalibrators(List<LoginFailureLineRegionCalibratable> actualFailureDates, List<LoginFailureLineRegionCalibratable> expectedFailureDates) {
        for (LoginFailureLineRegionCalibratable expectedDate : expectedFailureDates) {
            LoginFailureLineRegionCalibratable foundDate = addExpectedLine(actualFailureDates, expectedDate);
            if (foundDate == null) {
                addChildCalibrator(LoginFailureLineRegionCalibrator.getInstance(expectedDate, null));
            } else {
                actualFailureDates.remove(foundDate);
            }
        }
    }

    private LoginFailureLineRegionCalibratable addExpectedLine(List<LoginFailureLineRegionCalibratable> actualFailureDates, LoginFailureLineRegionCalibratable expectedDate) {
        for (LoginFailureLineRegionCalibratable candidate : actualFailureDates) {
            if (candidate.equivalent(expectedDate)) {
                addChildCalibrator(LoginFailureLineRegionCalibrator.getInstance(expectedDate, candidate));
                return candidate;
            }
        }
        return null;
    }

    @Override
    protected void executeVerifications() {
        verify("Title", expected.getTitle(), actual.getTitle());
        verify("'Log Not Found' message", expected.getLogNotFound(), actual.getLogNotFound());
    }
}
