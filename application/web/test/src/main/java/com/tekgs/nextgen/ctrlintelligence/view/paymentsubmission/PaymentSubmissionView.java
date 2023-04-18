package com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.ctrlintelligence.data.payment.CiPaymentDefinition;
import com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission.form.PaymentFormRegion;
import org.softwareonpurpose.gauntlet.Environment;

import java.util.List;

public class PaymentSubmissionView extends UiView implements PaymentSubmissionViewCalibratable {
    private static final String QUERY_STRING = "?cart_id=%s";
    private static final String LOCATOR_VALUE = "payment-submission";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String DESCRIPTION = "'Payment Submission' view";
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String RELATIVE_URL = "payment-submission";
    private static final String VIEW_URI = String.format("%s/%s", DOMAIN_URL, RELATIVE_URL);

    public PaymentSubmissionView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static PaymentSubmissionView directNav(String id) {
        new PaymentSubmissionView().load(String.format(QUERY_STRING, id));
        return UiView.expect(PaymentSubmissionView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    public PaymentSubmissionView submit(CiPaymentDefinition payment) {
        setSource(payment);
        setCurrency(payment);
        getSubmitButtonElement().click();
        return UiView.expect(PaymentSubmissionView.class);
    }

    private void setSource(CiPaymentDefinition payment) {
        getSourceElement().set(payment.getSource());
    }

    private void setCurrency(CiPaymentDefinition payment) {
        for(UiElement currencyElement: getCurrencyElements()){
            if(currencyElement.getAttribute("value").equalsIgnoreCase(payment.getCurrency())){
                currencyElement.click();
            }
        }

    }

    private List<UiElement> getCurrencyElements() {
        return UiElement.getList("Currency's", UiLocatorType.NAME, "currency", this.getElement());
    }

    private UiElement getSourceElement() {
        return UiElement.getInstance("Source", UiLocatorType.NAME, "source", this.getElement());
    }

    private UiElement getViewElementById(String description, String locatorValue) {
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }

    private UiElement getSubmitButtonElement() {
        String description = "Submit Button";
        String locatorValue = "submit-button";
        return getViewElementById(description, locatorValue);
    }

    private UiElement getPurchaseSuccessMessageElement() {
        String description = "'Purchase Success' message";
        String locatorValue = "result-message";
        return getViewElementById(description, locatorValue);
    }

    @Override
    public String getPurchaseSuccessMessage() {
        return getPurchaseSuccessMessageElement().getText();
    }

    @Override
    public PaymentFormRegion inPaymentFormRegion() {
        String description = "'Payment' form";
        String locatorValue = "payment-form";
        UiElement form = getViewElementById(description, locatorValue);
        return form.isDisplayed() ? PaymentFormRegion.getInstance(this.getElement()) : null;
    }

    public PaymentSubmissionView enter(CiPaymentDefinition paymentData) {
        setCurrency(paymentData);
        setSource(paymentData);
        getSubmitButtonElement().click();
        return UiView.expect(PaymentSubmissionView.class);
    }
}
