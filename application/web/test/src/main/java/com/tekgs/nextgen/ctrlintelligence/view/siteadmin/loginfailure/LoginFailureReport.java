package com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.line.LoginFailureLineRegion;
import com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.line.LoginFailureLineRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class LoginFailureReport extends UiRegion implements LoginFailureReportCalibratable {
    private static final String DESCRIPTION = "'Failure Report' region";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "failure-report";

    private LoginFailureReport(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static LoginFailureReport getInstance(UiElement parent) {
        return new LoginFailureReport(parent);
    }

    @Override
    public String getTitle() {
        return getTitleElement().getText();
    }

    @Override
    public List<LoginFailureLineRegionCalibratable> getFailureLines() {
        List<LoginFailureLineRegionCalibratable> failureDates = new ArrayList<>();
        for (UiElement dateElement : getDateElements()) {
            failureDates.add(LoginFailureLineRegion.getInstance(dateElement));
        }
        return failureDates;
    }

    @Override
    public String getLogNotFound() {
        return getLogNotFoundElement().getText();
    }

    private UiElement getLogNotFoundElement() {
        String description = "'Log Not Found' message";
        String locatorValue = "not-found-message";
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }

    private List<UiElement> getDateElements() {
        String description = "Failure Date";
        String locatorValue = "failure-aggregation";
        return UiElement.getList(description, UiLocatorType.CLASS, locatorValue, this.getElement());
    }

    private UiElement getTitleElement() {
        String description = "'Name'";
        String locatorValue = "login-report-title";
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }
}
