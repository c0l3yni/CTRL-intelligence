package com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission;

public class PaymentSubmissionCopy {
    public static PaymentSubmissionCopy getInstance() {
        return new PaymentSubmissionCopy();
    }
    
    public String getPurchaseSuccessMessage() {
        return "Thank you for your purchase";
    }
}
