package com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission.form.PaymentFormRegionCalibrator;

public class PaymentSubmissionViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Payment Submission' view";
    private final PaymentSubmissionView actual;
    private final PaymentSubmissionViewExpected expected;

    private PaymentSubmissionViewCalibrator(PaymentSubmissionViewExpected expected, PaymentSubmissionView actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
        addChildCalibrator(PaymentFormRegionCalibrator.getInstance(expected.inPaymentFormRegion(), actual.inPaymentFormRegion()));
    }

    public static PaymentSubmissionViewCalibrator getInstance(PaymentSubmissionViewExpected expected, PaymentSubmissionView actual) {
        return new PaymentSubmissionViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        String purchaseSuccessDescription = "'Purchase Success' message";
        verify(purchaseSuccessDescription, expected.getPurchaseSuccessMessage(), actual.getPurchaseSuccessMessage());
    }
}
