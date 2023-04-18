package com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission.form;

import com.tekgs.nextgen.ctrlintelligence.data.payment.CiPaymentDefinition;

public class PaymentFormRegionExpected implements PaymentFormRegionCalibratable {
    public static final String DOLLAR_FORMAT = "%.2f";
    public static final int ONE_DOLLAR_IN_CENTS = 100;
    private final CiPaymentDefinition payment;
    private PaymentFormRegionCopy copy;

    public PaymentFormRegionExpected(CiPaymentDefinition payment) {
        this.payment = payment;
    }

    public static PaymentFormRegionExpected getInstance(CiPaymentDefinition payment) {
        return new PaymentFormRegionExpected(payment);
    }

    private PaymentFormRegionCopy getCopy() {
        if (copy == null) {
            copy = PaymentFormRegionCopy.getInstance();
        }
        return copy;
    }

    @Override
    public String getTotalAmount() {
        double amountAsDollars = payment == null ? 0 : (double) payment.getAmount() / ONE_DOLLAR_IN_CENTS;
        return String.format(DOLLAR_FORMAT, amountAsDollars);
    }

    @Override
    public String getSourceErrorMessage() {
        return payment == null || isSourceValid() ? "" : getCopy().getSourceErrorMessage();
    }

    private boolean isSourceValid() {
        return "tok_amex".equals(payment.getSource());
    }

    @Override
    public String getPurchaseFailureMessage() {
        return (payment != null && isSourceValid()) && (!isAmountValid() || !isCurrencyValid())  ? getCopy().getPurchaseFailureMessage() : "";
    }

    private boolean isCurrencyValid() {
        return "usd".equals(payment.getCurrency());
    }

    private boolean isAmountValid() {
        return payment.getAmount() > 49 && payment.getAmount() < 1_000_000_00;
    }
}
