package com.tekgs.nextgen.ctrlintelligence.view.siteadmin;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.ctrlintelligence.view.siteadmin.loginfailure.LoginFailureReport;
import org.softwareonpurpose.gauntlet.Environment;

public class SiteAdminView extends UiView implements SiteAdminViewCalibratable {
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String RELATIVE_URL = "site-admin";
    private static final String VIEW_URI = String.format("%s/%s", DOMAIN_URL, RELATIVE_URL);
    private static final String DESCRIPTION = "'Site Admin' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "site-admin";
    private static final String QUERY_STRING = "?fileName=%s";

    public SiteAdminView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static SiteAdminView directNav() {
        new SiteAdminView().load();
        return UiView.expect(SiteAdminView.class);
    }

    public static SiteAdminView directNav(String loginFailureFile) {
        new SiteAdminView().load(String.format(QUERY_STRING, loginFailureFile));
        return UiView.expect(SiteAdminView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    @Override
    public LoginFailureReport inFailureReportRegion() {
        return LoginFailureReport.getInstance(this.getElement());
    }
}
