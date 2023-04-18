package com.tekgs.nextgen.ctrlintelligence.view.region;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public abstract class CtrlIntelligenceRegion extends UiRegion {
    public CtrlIntelligenceRegion(UiElement regionElement) {
        super(regionElement);
    }

    protected UiElement getById(String description, String locatorValue) {
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue);
    }
}
