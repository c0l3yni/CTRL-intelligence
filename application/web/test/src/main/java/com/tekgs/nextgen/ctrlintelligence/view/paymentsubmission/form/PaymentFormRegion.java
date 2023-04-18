package com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission.form;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public class PaymentFormRegion extends UiRegion implements PaymentFormRegionCalibratable {
    private static final String DESCRIPTION = "'Payment Form' region";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "payment-form";

    protected PaymentFormRegion(UiElement parentElement) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parentElement));
    }

    public static PaymentFormRegion getInstance(UiElement parent) {
        return new PaymentFormRegion(parent);
    }

    private UiElement getTotalAmountElement() {
        String description = "'Total Amount' message";
        String locatorValue = "total";
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue);
    }

    @Override
    public String getTotalAmount() {
        return getTotalAmountElement().getText();
    }

    @Override
    public String getSourceErrorMessage() {
        return getSourceErrorMessageElement().getText();
    }

    @Override
    public String getPurchaseFailureMessage() {
        return getPurchaseFailureMessageElement().getText();
    }

    private UiElement getPurchaseFailureMessageElement() {
        return  UiElement.getInstance("'Purchase Failure' message", UiLocatorType.ID, "purchase-error", this.getElement());
    }

    private UiElement getSourceErrorMessageElement() {
        String description = "'Source Error' message";
        String locatorValue = "source-error";
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }
}
