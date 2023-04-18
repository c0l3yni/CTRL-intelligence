package com.tekgs.nextgen.ctrlintelligence.service.purchase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseResponse implements PurchaseResponseCalibratable {
    private String message;
    private ResponseCode responseCode;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public enum ResponseCode {
        SUCCESS,
        FAILURE
    }
}
