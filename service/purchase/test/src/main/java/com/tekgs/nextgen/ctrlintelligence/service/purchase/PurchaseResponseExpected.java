package com.tekgs.nextgen.ctrlintelligence.service.purchase;

import com.tekgs.nextgen.ctrlintelligence.service.payment.data.payment.CiPayment;
import com.tekgs.nextgen.ctrlintelligence.service.purchase.PurchaseResponse.ResponseCode;

public class PurchaseResponseExpected implements PurchaseResponseCalibratable {
    private final String message;
    private final ResponseCode responseCode;

    private PurchaseResponseExpected(CiPayment payment) {
        this.message = payment.isValidPayment() ? "Purchase confirmed" : "Purchase failed, try again";
        this.responseCode = payment.isValidPayment() ? ResponseCode.SUCCESS : ResponseCode.FAILURE;
    }

    public static PurchaseResponseExpected getInstance(CiPayment payment) {
        return new PurchaseResponseExpected(payment);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public ResponseCode getResponseCode() {
        return responseCode;
    }
}
