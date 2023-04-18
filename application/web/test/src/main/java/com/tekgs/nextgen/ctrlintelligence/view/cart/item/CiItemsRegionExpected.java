package com.tekgs.nextgen.ctrlintelligence.view.cart.item;

import com.tekgs.nextgen.ctrlintelligence.data.cart.item.CiItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CiItemsRegionExpected implements CiItemsRegionCalibratable {
    private final List<CiItemRegionCalibratable> items = new ArrayList<>();

    public CiItemsRegionExpected(List<CiItemCalibratable> items) {
        if (items != null) {
            for (CiItemCalibratable item : items) {
                this.items.add(CiItemRegionExpected.getInstance(item));
            }
        }
    }

    public static CiItemsRegionExpected getInstance() {
        return new CiItemsRegionExpected(new ArrayList<>());
    }

    public static CiItemsRegionExpected getInstance(List<CiItemCalibratable> items) {
        return new CiItemsRegionExpected(items);
    }

    @Override
    public List<CiItemRegionCalibratable> getItems() {
        return items;
    }
}
