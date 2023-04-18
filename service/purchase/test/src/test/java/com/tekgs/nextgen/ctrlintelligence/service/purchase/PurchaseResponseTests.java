package com.tekgs.nextgen.ctrlintelligence.service.purchase;

import com.tekgs.nextgen.ctrlintelligence.service.payment.data.payment.CiPayment;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Service.PAYMENT, GauntletTest.Endpoint.PURCHASE})
public class PurchaseResponseTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {CiPayment.getInstance("usd", "tok_amex", 50)},
                {CiPayment.getInstance("usd", "tok_amex", 99999999)},
                {CiPayment.getInstance("bogus", "tok_amex", 100)},
                {CiPayment.getInstance("usd", "bogus", 100)},
                {CiPayment.getInstance("usd", "tok_amex", 1000000000)},
                {CiPayment.getInstance("usd", "tok_amex", -50)},
                {CiPayment.getInstance("usd", "tok_amex", 49)}
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("93 - Payment Confirmation");
        CiPayment payment = CiPayment.getInstance("usd", "tok_amex", 999);
        given(payment);
        PurchaseResponseExpected expected = PurchaseResponseExpected.getInstance(payment);
        when();
        PurchaseResponse actual = PurchaseRequest.getInstance(payment).post();
        then(PurchaseResponseCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dataProvider = "scenarios", dependsOnMethods = "smoke")
    public void post(CiPayment payment) {
        addRequirements("93 - Payment Confirmation");
        PurchaseResponseExpected expected = PurchaseResponseExpected.getInstance(payment);
        PurchaseResponse actual = PurchaseRequest.getInstance(payment).post();
        then(PurchaseResponseCalibrator.getInstance(expected, actual));
    }
}
