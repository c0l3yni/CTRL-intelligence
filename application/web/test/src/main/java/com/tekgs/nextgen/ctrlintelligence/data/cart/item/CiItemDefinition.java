package com.tekgs.nextgen.ctrlintelligence.data.cart.item;


public class CiItemDefinition implements CiItemCalibratable {
    private String name;
    @SuppressWarnings("unused")
    private Integer price;
    @SuppressWarnings("unused")
    private Integer quantity;

    public static CiItemDefinition getInstance() {
        return new CiItemDefinition();
    }

    @Override
    public boolean equivalent(CiItemCalibratable comparator) {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    public CiItemDefinition withName(String name) {
        this.name = name;
        return this;
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
        return getQuantity() * getPrice();
    }
}
