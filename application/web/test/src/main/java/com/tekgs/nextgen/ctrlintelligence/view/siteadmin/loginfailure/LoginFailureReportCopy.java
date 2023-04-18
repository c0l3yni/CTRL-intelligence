package com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure;

import com.tekgs.nextgen.ctrlintelligence.view.copy.CtrlIntelligenceCopy;

public class LoginFailureReportCopy {
    private CtrlIntelligenceCopy copy;

    public static LoginFailureReportCopy getInstance() {
        return new LoginFailureReportCopy();
    }

    public String getFailureReportTitle() {
        return getCopy().getFailureReportTitle();
    }

    private CtrlIntelligenceCopy getCopy() {
        if (copy == null) {
            copy = CtrlIntelligenceCopy.getInstance();
        }
        return copy;
    }

    public String getLoginFileNotFound() {
        return getCopy().getLoginFileNotFound();
    }
}
