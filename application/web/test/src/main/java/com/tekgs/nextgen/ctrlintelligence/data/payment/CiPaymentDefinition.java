package com.tekgs.nextgen.ctrlintelligence.data.payment;

import com.google.gson.Gson;

@SuppressWarnings("unused")
public class CiPaymentDefinition {
    private int amount;
    private String currency = "usd";
    private String source = "tok_amex";

    public static CiPaymentDefinition getInstance() {
        return new CiPaymentDefinition();
    }

    public CiPaymentDefinition withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("PaymentDefinition %s", new Gson().toJson(this));
    }

    public String getCurrency() {
        return currency;
    }

    public String getSource() {
        return source;
    }

    public CiPaymentDefinition withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public CiPaymentDefinition withSource(String source) {
        this.source = source;
        return this;
    }
}
