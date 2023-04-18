package com.tekgs.nextgen.ctrlintelligence.view.siteadmin;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.CTRL_INTELLIGENCE, GauntletTest.View.SITE_ADMIN})
public class SiteAdminViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {"LoginErrorLog_one-day-two"}
                , {"LoginErrorLog_twenty-eight-days-some-missing"}
        };
    }

    @Test(groups = {})
    public void smoke() {
        addRequirements("102 - Customer Experience");
        SiteAdminViewExpected expected = SiteAdminViewExpected.getInstance();
        when();
        SiteAdminView actual = SiteAdminView.directNav();
        then(SiteAdminViewCalibrator.getInstance(expected, actual));
    }

    @Test(dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(String loginFailureLogFile) {
        given(loginFailureLogFile);
        SiteAdminViewExpected expected = SiteAdminViewExpected.getInstance(loginFailureLogFile);
        when();
        SiteAdminView actual = SiteAdminView.directNav(loginFailureLogFile);
        then(SiteAdminViewCalibrator.getInstance(expected, actual));
    }
}
