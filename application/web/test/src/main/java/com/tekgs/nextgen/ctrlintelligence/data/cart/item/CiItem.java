package com.tekgs.nextgen.ctrlintelligence.data.cart.item;

public class CiItem implements CiItemCalibratable {
    private final String name;
    private final Integer price;
    private final Integer quantity;

    private CiItem() {
        name = null;
        price = null;
        quantity = null;
    }

    @Override
    public boolean equivalent(CiItemCalibratable comparator) {
        return comparator.getName() == null || this.getName().equals(comparator.getName());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public Integer getSubtotal() {
        return getPrice() * getQuantity();
    }
}
