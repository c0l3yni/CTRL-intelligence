package com.tekgs.nextgen.ctrlintelligence.data.cart;

import com.tekgs.nextgen.ctrlintelligence.data.cart.item.CiItemCalibratable;

import java.util.List;

public interface CiCartCalibratable {
    Integer getTotal();

    List<CiItemCalibratable> getItems();

    String getId();

    Integer getItemCount();

    Boolean isEmpty();
}
