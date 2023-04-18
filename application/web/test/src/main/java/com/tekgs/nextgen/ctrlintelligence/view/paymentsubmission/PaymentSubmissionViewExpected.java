package com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission;

import com.tekgs.nextgen.ctrlintelligence.data.payment.CiPaymentDefinition;
import com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission.form.PaymentFormRegionExpected;

public class PaymentSubmissionViewExpected implements PaymentSubmissionViewCalibratable {
    private final CiPaymentDefinition payment;
    private final boolean isPaymentSubmitted;
    private PaymentSubmissionCopy copy;

    private PaymentSubmissionViewExpected(CiPaymentDefinition payment, boolean isPaymentSubmitted) {
        this.payment = payment;
        this.isPaymentSubmitted = isPaymentSubmitted;
    }

    public static PaymentSubmissionViewExpected getInstance(Integer cartTotal) {
        CiPaymentDefinition payment = CiPaymentDefinition.getInstance().withAmount(cartTotal);
        return new PaymentSubmissionViewExpected(payment, false);
    }

    public static PaymentSubmissionViewExpected getPaymentSubmittedInstance(CiPaymentDefinition payment) {
        return new PaymentSubmissionViewExpected(payment, true);
    }

    @Override
    public String getPurchaseSuccessMessage() {
        if (isPaymentSubmitted) {
            return payment != null && isPaymentValid() ? getCopy().getPurchaseSuccessMessage() : "";
        } else {
            return "";
        }
    }

    private boolean isPaymentValid() {
        return isAmountValid() && "usd".equals(payment.getCurrency()) && "tok_amex".equals(payment.getSource());
    }

    private boolean isAmountValid() {
        return payment.getAmount() > 49 && payment.getAmount() < 1_000_000_00;
    }

    @Override
    public PaymentFormRegionExpected inPaymentFormRegion() {
        return isPaymentSubmitted && isPaymentValid() ? null : PaymentFormRegionExpected.getInstance(payment);
    }

    private PaymentSubmissionCopy getCopy() {
        if (copy == null) {
            copy = PaymentSubmissionCopy.getInstance();
        }
        return copy;
    }
}
