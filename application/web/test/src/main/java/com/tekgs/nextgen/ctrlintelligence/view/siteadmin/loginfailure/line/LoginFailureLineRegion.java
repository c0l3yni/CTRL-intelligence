package com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.line;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.tekgs.nextgen.ctrlintelligence.behavior.EquivalenceBehavior;
import com.tekgs.nextgen.ctrlintelligence.view.region.CtrlIntelligenceRegion;

public class LoginFailureLineRegion extends CtrlIntelligenceRegion implements LoginFailureLineRegionCalibratable {
    private LoginFailureLineRegion(UiElement regionElement) {
        super(regionElement);
    }

    public static LoginFailureLineRegion getInstance(UiElement dateElement) {
        return new LoginFailureLineRegion(dateElement);
    }

    private static boolean areEquivalent(Object comparatorValue, Object thisValue) {
        return EquivalenceBehavior.getInstance(comparatorValue, thisValue).execute();
    }

    @Override
    public boolean equivalent(LoginFailureLineRegionCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        boolean isEquivalent = areEquivalent(comparator.getDate(), this.getDate());
        isEquivalent &= areEquivalent(comparator.getCount(), this.getCount());
        return isEquivalent;
    }

    private UiElement getDateElement() {
        return UiElement.getInstance("Date", UiLocatorType.CLASS, "failure-date", this.getElement());
    }

    @Override
    public String getDate() {
        return getDateElement().getText();
    }

    private UiElement getCountElement() {
        String description = "Count";
        String locatorValue = "number-failures";
        return UiElement.getInstance(description, UiLocatorType.CLASS, locatorValue, this.getElement());
    }

    @Override
    public String getCount() {
        return getCountElement().getText();
    }

    @Override
    public String getFailureDateLabel() {
        return getFailureDateLabelElement().getText();
    }

    private UiElement getFailureDateLabelElement() {
        String description = "'failure-date' label";
        String locatorValue = "failure-date-label";
        return getById(description, locatorValue);
    }
}
