package com.tekgs.nextgen.ctrlintelligence.service.purchase;

import com.tekgs.nextgen.ctrlintelligence.service.purchase.PurchaseResponse.ResponseCode;

public interface PurchaseResponseCalibratable {
    String getMessage();
    ResponseCode getResponseCode();
}
