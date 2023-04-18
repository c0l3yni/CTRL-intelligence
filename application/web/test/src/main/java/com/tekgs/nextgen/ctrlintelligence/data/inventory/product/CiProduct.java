package com.tekgs.nextgen.ctrlintelligence.data.inventory.product;

import com.google.gson.Gson;

public class CiProduct {
    private String name;
    private Integer quantity;

    public String getName() {
        return name;
    }

    public Integer getQuantity(){
        return quantity;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
