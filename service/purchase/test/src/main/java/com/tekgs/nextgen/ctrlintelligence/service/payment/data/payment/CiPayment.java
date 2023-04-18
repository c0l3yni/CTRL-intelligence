package com.tekgs.nextgen.ctrlintelligence.service.payment.data.payment;

import com.google.gson.Gson;

public class CiPayment {
    private final String currency;
    private final String source;
    private final long amount;

    private CiPayment(String currency, String source, long amount) {
        this.currency = currency;
        this.source = source;
        this.amount = amount;
    }

    public static CiPayment getInstance(String currency, String source, long amount) {
        return new CiPayment(currency, source, amount);
    }

    public Boolean isValidPayment() {
        return "usd".equals(currency) && "tok_amex".equals(source) && amount >= 50 && amount < 100000000;
    }

    @SuppressWarnings("unused")
    public String getCurrency() {
        return currency;
    }

    @SuppressWarnings("unused")
    public String getSource() {
        return source;
    }

    @SuppressWarnings("unused")
    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.getClass().getSimpleName(), new Gson().toJson(this));
    }
}
