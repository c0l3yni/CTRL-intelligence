package com.tekgs.nextgen.ctrlintelligence.data.cart;

import com.google.gson.Gson;
import com.tekgs.nextgen.ctrlintelligence.data.cart.item.CiItem;
import com.tekgs.nextgen.ctrlintelligence.data.cart.item.CiItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CiCart implements CiCartCalibratable {
    private final String id;
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<CiItem> items = new ArrayList<>();

    private CiCart(CiCartDefinition cart) {
        this.id = cart.getId();
    }

    public static CiCart getInstance(CiCartDefinition cartDefinition) {
        return new CiCart(cartDefinition);
    }

    @Override
    public Integer getTotal() {
        int total = 0;
        for (CiItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    @Override
    public List<CiItemCalibratable> getItems() {
        return new ArrayList<>(this.items);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Integer getItemCount() {
        return items.size();
    }

    @Override
    public Boolean isEmpty() {
        return getItemCount() == 0;
    }

    public boolean equivalent(CiCartDefinition definition) {
        boolean isEquivalent = definition.getTotal() == null || this.getTotal().equals(definition.getTotal());
        isEquivalent &= definition.getItemCount() == null || this.getItemCount().equals(definition.getItemCount());
        isEquivalent &= areItemsEquivalent(definition.getItems());
        return isEquivalent;
    }

    private boolean areItemsEquivalent(List<CiItemCalibratable> itemDefinitions) {
        List<CiItem> thisItems = new ArrayList<>(items);
        for (CiItemCalibratable itemDefinition : itemDefinitions) {
            CiItemCalibratable foundItem = null;
            for (CiItemCalibratable candidate : thisItems) {
                if (candidate.equivalent(itemDefinition)) {
                    foundItem = candidate;
                    break;
                }
            }
            if (foundItem == null) {
                return false;
            } else {
                //noinspection ReassignedVariable,SuspiciousMethodCalls
                thisItems.remove(foundItem);
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
