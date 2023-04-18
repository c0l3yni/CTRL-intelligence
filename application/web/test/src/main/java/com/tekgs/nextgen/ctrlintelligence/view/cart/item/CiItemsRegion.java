package com.tekgs.nextgen.ctrlintelligence.view.cart.item;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

import java.util.ArrayList;
import java.util.List;

public class CiItemsRegion extends UiRegion implements CiItemsRegionCalibratable {
    private static final String DESCRIPTION = "'Items' region";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "items";
    
    protected CiItemsRegion(UiElement parentElement) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parentElement));
    }
    
    public static CiItemsRegion getInstance(UiElement parent) {
        return new CiItemsRegion(parent);
    }
    
    @Override
    public List<CiItemRegionCalibratable> getItems() {
        ArrayList<CiItemRegionCalibratable> items = new ArrayList<>();
        for (UiElement itemElement : UiElement.getList("Item", UiLocatorType.CLASS, "item", this.getElement())) {
            items.add(CiItemRegion.getInstance(itemElement));
        }
        return items;
    }
}
