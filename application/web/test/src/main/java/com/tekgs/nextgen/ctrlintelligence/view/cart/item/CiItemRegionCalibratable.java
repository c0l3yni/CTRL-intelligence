package com.tekgs.nextgen.ctrlintelligence.view.cart.item;

public interface CiItemRegionCalibratable {
    boolean equivalent(CiItemRegionCalibratable comparator);

    boolean isRemoveItemButtonDisplayed();

    String getName();

    String getItemQuantity();

    String getSubtotal();
}
