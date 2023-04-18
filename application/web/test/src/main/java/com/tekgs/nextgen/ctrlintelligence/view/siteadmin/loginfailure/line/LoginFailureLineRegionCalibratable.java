package com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.line;

public interface LoginFailureLineRegionCalibratable {
    boolean equivalent(LoginFailureLineRegionCalibratable comparator);

    String getDate();

    String getCount();

    String getFailureDateLabel();
}
