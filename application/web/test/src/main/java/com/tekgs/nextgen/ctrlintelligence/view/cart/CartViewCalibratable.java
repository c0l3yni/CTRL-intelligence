package com.tekgs.nextgen.ctrlintelligence.view.cart;

import com.tekgs.nextgen.ctrlintelligence.view.cart.item.CiItemsRegionCalibratable;

public interface CartViewCalibratable {
    String getCartTotal();
    CiItemsRegionCalibratable inAllItemsRegion();

    String getEmptyMessage();

    boolean isCheckoutButtonDisplayed();
}
