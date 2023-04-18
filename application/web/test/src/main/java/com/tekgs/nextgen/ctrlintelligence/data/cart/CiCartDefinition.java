package com.tekgs.nextgen.ctrlintelligence.data.cart;

import com.google.gson.Gson;
import com.tekgs.nextgen.ctrlintelligence.data.cart.item.CiItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CiCartDefinition implements CiCartCalibratable {
    private final List<CiItemCalibratable> items = new ArrayList<>();
    private Integer total;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private Integer count;
    private String id;

    public static CiCartDefinition getInstance() {
        return new CiCartDefinition();
    }

    @Override
    public Integer getTotal() {
        return total;
    }

    @Override
    public List<CiItemCalibratable> getItems() {
        return items;
    }

    @Override
    public String getId() {
        return id;
    }

    public CiCartDefinition withId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public Integer getItemCount() {
        return count;
    }

    @Override
    public Boolean isEmpty() {
        return count == null ? null : count == 0 && items.size() == 0;
    }

    public CiCartDefinition withTotal(Integer total) {
        this.total = total;
        return this;
    }

    @Override
    public String toString() {
        return String.format("CartDefinition %s", new Gson().toJson(this));
    }

    public CiCartDefinition withItem(CiItemCalibratable itemDefinition) {
        items.add(itemDefinition);
        return this;
    }

    public CiCartDefinition withItemCount(int count) {
        this.count = count;
        return this;
    }
}
