package com.tekgs.nextgen.ctrlintelligence.view.paymentsubmission;

import com.tekgs.nextgen.ctrlintelligence.data.cart.CiCart;
import com.tekgs.nextgen.ctrlintelligence.data.cart.CiCartDefinition;
import com.tekgs.nextgen.ctrlintelligence.data.cart.CiCartProvider;
import com.tekgs.nextgen.ctrlintelligence.data.payment.CiPaymentDefinition;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.CTRL_INTELLIGENCE, GauntletTest.View.PAYMENT_SUBMISSION})
public class PaymentSubmissionViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] submitScenarios() {
        int oneLessThanOneMillion = 99999999;
        int fiftyCents = 50;
        return new Object[][]{
                {CiPaymentDefinition.getInstance().withAmount(fiftyCents)}
                , {CiPaymentDefinition.getInstance().withAmount(oneLessThanOneMillion)}
                , {CiPaymentDefinition.getInstance().withAmount(0)}
        };
    }

    @DataProvider
    public static Object[][] paymentScenarios() {
        return new Object[][]{
                {CiPaymentDefinition.getInstance()
                        .withCurrency("bogus")
                        .withSource("bogus")
                        .withAmount(50)},
                {CiPaymentDefinition.getInstance()
                        .withCurrency("bogus")
                        .withAmount(0)},
                {CiPaymentDefinition.getInstance()
                        .withSource("bogus")}
        };
    }

    @Test(groups = {})
    public void smoke() {
        addRequirements("102 - Customer Experience");
        CiCart cart = CiCartProvider.getInstance().get();
        given(cart);
        PaymentSubmissionViewExpected expected = PaymentSubmissionViewExpected.getInstance(cart.getTotal());
        when();
        PaymentSubmissionView actual = PaymentSubmissionView.directNav(cart.getId());
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {}, dependsOnMethods = "smoke")
    public void release() {
        int fiftyCents = 50;
        CiPaymentDefinition payment = CiPaymentDefinition.getInstance().withAmount(fiftyCents);
        CiCartDefinition cartDefinition = CiCartDefinition.getInstance().withTotal(payment.getAmount());
        CiCart cart = CiCartProvider.getInstance().getLowestTotalAvailable(cartDefinition);
        given(payment);
        PaymentSubmissionViewExpected expected = PaymentSubmissionViewExpected.getPaymentSubmittedInstance(payment);
        PaymentSubmissionView actual = PaymentSubmissionView.directNav(cart.getId()).submit(payment);
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {}, dependsOnMethods = "smoke", dataProvider = "submitScenarios")
    public void submit(CiPaymentDefinition payment) {
        CiCartDefinition cartDefinition = CiCartDefinition.getInstance().withTotal(payment.getAmount());
        CiCart cart = CiCartProvider.getInstance().getLowestTotalAvailable(cartDefinition);
        given(payment);
        PaymentSubmissionViewExpected expected = PaymentSubmissionViewExpected.getPaymentSubmittedInstance(payment);
        PaymentSubmissionView actual = PaymentSubmissionView.directNav(cart.getId()).submit(payment);
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {}, dependsOnMethods = "smoke", dataProvider = "paymentScenarios")
    public void fieldValidation(CiPaymentDefinition paymentData) {
        addRequirements("111 - 'Payment Submission' - Failure Message");
        CiCartDefinition cartDefinition = CiCartDefinition.getInstance().withTotal(paymentData.getAmount());
        CiCart cart = CiCartProvider.getInstance().getLowestTotalAvailable(cartDefinition);
        given(paymentData);
        PaymentSubmissionViewExpected expected =
                PaymentSubmissionViewExpected.getPaymentSubmittedInstance(paymentData);
        when();
        PaymentSubmissionView actual = PaymentSubmissionView.directNav(cart.getId()).submit(paymentData);
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }
}
