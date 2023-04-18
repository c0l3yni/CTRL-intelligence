package com.tekgs.nextgen.ctrlintelligence.purchase.model.payment;

@SuppressWarnings("unused")
public class CiPayment {
    private Long amount;
    private String currency;
    private String source;

    public Long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSource() {
        return source;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
