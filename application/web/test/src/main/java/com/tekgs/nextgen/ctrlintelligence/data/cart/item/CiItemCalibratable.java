package com.tekgs.nextgen.ctrlintelligence.data.cart.item;

public interface CiItemCalibratable {
    boolean equivalent(CiItemCalibratable comparator);

    String getName();

    Integer getPrice();

    Integer getQuantity();

    Integer getSubtotal();
}
