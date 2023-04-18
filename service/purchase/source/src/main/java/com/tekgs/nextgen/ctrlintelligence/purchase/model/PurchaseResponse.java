package com.tekgs.nextgen.ctrlintelligence.purchase.model;

import com.google.gson.Gson;

public class PurchaseResponse {
    private final String message;
    private ResponseCode responseCode = ResponseCode.FAILURE;

    private PurchaseResponse(String message, ResponseCode responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }

    public static PurchaseResponse getInstance(String message, ResponseCode responseCode) {
        return new PurchaseResponse(message, responseCode);
    }

    public enum ResponseCode {
        SUCCESS,
        FAILURE,
        UNHANDLED
    }

    public String getMessage(){
        return message;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.getClass().getSimpleName(), new Gson().toJson(this));
    }
}
