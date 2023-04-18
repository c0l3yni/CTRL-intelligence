package com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission;

import com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission.form.PaymentFormRegionCalibratable;

public interface PaymentSubmissionViewCalibratable {
    String getPurchaseSuccessMessage();
    PaymentFormRegionCalibratable inPaymentFormRegion();
}
