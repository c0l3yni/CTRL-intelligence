package com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission.form;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class PaymentFormRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Payment Form' region";
    private final PaymentFormRegionExpected expected;
    private final PaymentFormRegion actual;
    
    private PaymentFormRegionCalibrator(PaymentFormRegionExpected expected, PaymentFormRegion actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }
    
    public static PaymentFormRegionCalibrator getInstance(PaymentFormRegionExpected expected, PaymentFormRegion actual) {
        return new PaymentFormRegionCalibrator(expected, actual);
    }
    
    @Override
    protected void executeVerifications() {
        verify("Total", expected.getTotalAmount(), actual.getTotalAmount());
        verify("'Source Error' message", expected.getSourceErrorMessage(), actual.getSourceErrorMessage());
        verify("'Purchase Failure' message", expected.getPurchaseFailureMessage(),actual.getPurchaseFailureMessage());
    }
}
