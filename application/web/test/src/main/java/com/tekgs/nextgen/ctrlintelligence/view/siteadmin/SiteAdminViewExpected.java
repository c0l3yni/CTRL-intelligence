package com.tekgs.nextgen.ctrlintelligence.view.siteadmin;

import com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.LoginFailureReportExpected;

public class SiteAdminViewExpected implements SiteAdminViewCalibratable {
    private final String failureFile;

    public SiteAdminViewExpected(String loginFailureFile) {
        this.failureFile = loginFailureFile;
    }

    public static SiteAdminViewExpected getInstance() {
        return new SiteAdminViewExpected(null);
    }

    public static SiteAdminViewExpected getInstance(String loginFailureFile) {
        return new SiteAdminViewExpected(loginFailureFile);
    }

    @Override
    public LoginFailureReportExpected inFailureReportRegion() {
        return LoginFailureReportExpected.getInstance(failureFile);
    }
}
