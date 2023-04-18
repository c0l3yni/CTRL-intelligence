package com.tekgs.nextgen.ctrlintelligence.view.products.product;

public interface ProductRegionCalibratable {
    String getName();

    boolean equivalent(ProductRegionCalibratable comparator);

    Boolean isButtonDisplayed();

    String getOutOfStockMessage();

    Boolean isAddToCartEnabled();
}
