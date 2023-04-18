package com.tekgs.nextgen.ctrlintelligence.service.purchase;

import com.tekgs.nextgen.ctrlintelligence.service.payment.data.payment.CiPayment;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.softwareonpurpose.gauntlet.Environment;

public class PurchaseRequest {
    private final CiPayment payment;
    private static final String PATH = Environment.getInstance().getPath();
    private final ResteasyWebTarget target;

    private PurchaseRequest(CiPayment payment) {
        ResteasyClient client = (ResteasyClient) ClientBuilder.newBuilder().build();
        this.payment = payment;
        this.target = client.target(UriBuilder.fromPath(PATH));
    }

    public static PurchaseRequest getInstance(CiPayment payment) {
        return new PurchaseRequest(payment);
    }

    public PurchaseResponse post() {
        Entity<CiPayment> body = getPurchaseResponseBodyEntity();
        System.out.printf("Send 'POST' request to %s with %s ...", PATH, payment);
        PurchaseResponse purchaseResponse;
        try (Response response = target.request().post(body)) {
            purchaseResponse = response.readEntity(PurchaseResponse.class);
        }
        return purchaseResponse;
    }

    private Entity<CiPayment> getPurchaseResponseBodyEntity() {
        return Entity.json(payment);
    }
}
