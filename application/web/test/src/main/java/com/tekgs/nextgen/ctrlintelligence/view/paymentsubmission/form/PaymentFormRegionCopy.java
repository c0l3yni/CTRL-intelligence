package com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission.form;

import com.tekgs.nextgen.ctrlintelligence.view.copy.CtrlIntelligenceCopy;

public class PaymentFormRegionCopy {

    private CtrlIntelligenceCopy copy;

    public static PaymentFormRegionCopy getInstance() {
        return new PaymentFormRegionCopy();
    }

    private CtrlIntelligenceCopy getCopy() {
        if (copy == null) {
            copy = CtrlIntelligenceCopy.getInstance();
        }
        return copy;
    }

    public String getSourceErrorMessage() {
        return getCopy().getSourceErrorMessage();
    }


    public String getPurchaseFailureMessage() {
        return "Credit card declined or rejected. Please try again";
    }
}
