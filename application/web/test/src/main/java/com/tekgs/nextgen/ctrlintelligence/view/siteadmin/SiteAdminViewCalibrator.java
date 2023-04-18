package com.tekgs.nextgen.ctrlintelligence.view.siteadmin;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.LoginFailureReportCalibrator;

public class SiteAdminViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Site Admin' view";

    private SiteAdminViewCalibrator(SiteAdminViewExpected expected, SiteAdminView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addChildCalibrator(LoginFailureReportCalibrator.getInstance(expected.inFailureReportRegion(), actual.inFailureReportRegion()));
        UiRegion.suppressConstructionLogging(false);
    }

    public static SiteAdminViewCalibrator getInstance(SiteAdminViewExpected expected, SiteAdminView actual) {
        return new SiteAdminViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
