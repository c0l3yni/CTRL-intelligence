package com.tekgs.nextgen.ctrlintelligence.view.error;

import com.tekgs.nextgen.ctrlintelligence.data.cart.CiCartDefinition;
import com.tekgs.nextgen.ctrlintelligence.data.cart.item.CiItemDefinition;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.*;

@Test(groups = {GauntletTest.Application.CTRL_INTELLIGENCE, GauntletTest.View.ERROR_PAGE})
public class ErrorViewTests extends GauntletTest {

    @DataProvider
    public static Object[][] scenarios() {
        String bogusUrl = "bogus";
        String badUrl = "this-is-a-bad-URL";
        String keyboardSpamUrl = "spam-your-keyboard";
        return new Object[][] {
                {bogusUrl},
                {badUrl},
                {keyboardSpamUrl}
        };
    }
    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        ErrorViewExpected expected = ErrorViewExpected.getInstance();
        ErrorView actual = ErrorView.directNav();
        then(ErrorViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void invalidUrl(String url) {
        ErrorViewExpected expected = ErrorViewExpected.getInstance();
        ErrorView actual = ErrorView.directNav(url);
        then(ErrorViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke")
    public void catchAll() {
        addRequirements("104 - Error page - unhandled exception");
        String unhandledExceptionUrl = "simulate-error";
        String errorMessage = "Sorry, something went wrong. :(";
        ErrorViewExpected expected = ErrorViewExpected.getInstance(errorMessage);
        ErrorView actual = ErrorView.directNav(unhandledExceptionUrl);
        then(ErrorViewCalibrator.getInstance(expected, actual));
    }
}
    