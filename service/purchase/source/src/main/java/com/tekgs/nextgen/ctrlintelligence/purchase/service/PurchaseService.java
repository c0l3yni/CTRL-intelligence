package com.tekgs.nextgen.ctrlintelligence.purchase.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import com.tekgs.nextgen.ctrlintelligence.purchase.model.PurchaseResponse;
import com.tekgs.nextgen.ctrlintelligence.purchase.model.PurchaseResponse.ResponseCode;
import com.tekgs.nextgen.ctrlintelligence.purchase.model.payment.CiPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    private Environment environment;
    private static final String SUCCESS_MESSAGE = "Purchase confirmed";
    private static final String FAILURE_MESSAGE = "Purchase failed, try again";
    private static final String UNKNOWN_ERROR = "Unknown error";

    public PurchaseResponse post(CiPayment ciPayment) {
        PurchaseResponse retVal = PurchaseResponse.getInstance(UNKNOWN_ERROR, ResponseCode.UNHANDLED);
        Stripe.apiKey = environment.getProperty("stripe.api_key");
        try{
            Charge charge = Charge.create(ChargeCreateParams.builder()
                    .setAmount(ciPayment.getAmount())
                    .setCurrency(ciPayment.getCurrency())
                    .setSource(ciPayment.getSource())
                    .build());

            Boolean paid = charge.getPaid();
            String status = charge.getStatus();
            if (paid && "succeeded".equals(status)) {
                retVal = PurchaseResponse.getInstance(SUCCESS_MESSAGE, ResponseCode.SUCCESS);
            }
        } catch (StripeException e){
            retVal = PurchaseResponse.getInstance(FAILURE_MESSAGE, ResponseCode.FAILURE);
        }
        return retVal;
    }
}
