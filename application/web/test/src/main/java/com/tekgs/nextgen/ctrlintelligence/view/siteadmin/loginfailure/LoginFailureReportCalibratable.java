package com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure;

import com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.line.LoginFailureLineRegionCalibratable;

import java.util.List;

public interface LoginFailureReportCalibratable {
    String getTitle();

    List<LoginFailureLineRegionCalibratable> getFailureLines();

    String getLogNotFound();
}
