package com.tekgs.nextgen.ctrlintelligence.purchase.controller;

import com.tekgs.nextgen.ctrlintelligence.purchase.model.payment.CiPayment;
import com.tekgs.nextgen.ctrlintelligence.purchase.model.PurchaseResponse;
import com.tekgs.nextgen.ctrlintelligence.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/purchase")
@CrossOrigin("http://localhost:3000")
@ControllerAdvice
public class PurchaseController {
    @Autowired
    private PurchaseService paymentService;

    @PostMapping(consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public PurchaseResponse postPaymentToStripe(@RequestBody CiPayment ciPayment) {
        return paymentService.post(ciPayment);
    }
}
