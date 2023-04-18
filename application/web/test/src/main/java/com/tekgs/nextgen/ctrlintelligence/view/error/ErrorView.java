package com.tekgs.nextgen.ctrlintelligence.view.error;

import com.softwareonpurpose.uinavigator.*;

public class ErrorView extends UiView implements ErrorViewCalibratable {
    private static final String DOMAIN_URL = "http://localhost:3000";
    private static final String DESCRIPTION = "Error Page View";
    private static final String LOCATOR_VALUE = "error-page";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;

    public ErrorView() {
        super(DOMAIN_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static ErrorView directNav() {
        new ErrorView().load("error-page");
        return UiView.expect(ErrorView.class);
    }

    public static ErrorView directNav(String url) {
        new ErrorView().load(url);
        return UiView.expect(ErrorView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    @Override
    public String getErrorMessage() {
        return getErrorMessageElement().getText();
    }

    private UiElement getErrorMessageElement() {
        return UiElement.getInstance("Error Message", UiLocatorType.ID, "error-message");
    }
}
