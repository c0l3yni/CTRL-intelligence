package com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.line;

public class LoginFailureLineRegionExpected implements LoginFailureLineRegionCalibratable {

    private final String failureDate;
    private final Integer failureCount;
    private LoginFailureLineRegionCopy copy;

    public LoginFailureLineRegionExpected(String failureDate, Integer failureCount) {
        this.failureDate = failureDate;
        this.failureCount = failureCount;
    }

    public static LoginFailureLineRegionExpected getInstance(String failureDate, Integer failureCount) {
        return new LoginFailureLineRegionExpected(failureDate, failureCount);
    }

    @Override
    public boolean equivalent(LoginFailureLineRegionCalibratable comparator) {
        return false;
    }

    @Override
    public String getDate() {
        return failureDate;
    }

    @Override
    public String getCount() {
        return String.valueOf(failureCount);
    }

    @Override
    public String getFailureDateLabel() {
        return getCopy().getFailureDateLabel();
    }

    private LoginFailureLineRegionCopy getCopy() {
        if (copy == null) {
            copy = LoginFailureLineRegionCopy.getInstance();
        }
        return copy;
    }
}
