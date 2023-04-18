package com.tekgs.nextgen.ctrlintelligence.view.cart.item;

import com.tekgs.nextgen.ctrlintelligence.data.cart.item.CiItemCalibratable;

public class CiItemRegionExpected implements CiItemRegionCalibratable {
    private final CiItemCalibratable item;

    public CiItemRegionExpected(CiItemCalibratable item) {
        this.item = item;
    }

    public static CiItemRegionExpected getInstance(CiItemCalibratable item) {
        return new CiItemRegionExpected(item);
    }

    @Override
    public boolean equivalent(CiItemRegionCalibratable comparator) {
        return false;
    }

    @Override
    public boolean isRemoveItemButtonDisplayed() {
        return true;
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public String getItemQuantity() {
        return String.valueOf(item.getQuantity());
    }

    @Override
    public String getSubtotal() {
        double subtotalInDollars = (float) (item.getPrice() * item.getQuantity()) / 100;
        return String.format("$%.2f", subtotalInDollars);
    }
}
