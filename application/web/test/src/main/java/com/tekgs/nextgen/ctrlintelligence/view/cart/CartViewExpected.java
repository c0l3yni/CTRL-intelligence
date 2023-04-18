package com.tekgs.nextgen.ctrlintelligence.view.cart;

import com.tekgs.nextgen.ctrlintelligence.data.cart.CiCart;
import com.tekgs.nextgen.ctrlintelligence.view.cart.item.CiItemsRegionExpected;

import java.util.ArrayList;

public class CartViewExpected implements CartViewCalibratable {
    private final CiCart cart;

    public CartViewExpected(CiCart cart) {
        this.cart = cart;
    }

    public static CartViewExpected getInstance(CiCart cart) {
        return new CartViewExpected(cart);
    }

    public static CartViewExpected getInstance() {
        return new CartViewExpected(null);
    }

    @Override
    public String getCartTotal() {
        double totalInDollars = cart == null ? 0 : (double) cart.getTotal() / 100;
        return String.format("%.2f", totalInDollars);
    }

    @Override
    public CiItemsRegionExpected inAllItemsRegion() {
        return cart == null ? CiItemsRegionExpected.getInstance(new ArrayList<>())
                : CiItemsRegionExpected.getInstance(cart.getItems());
    }

    @Override
    public String getEmptyMessage() {
        return cart == null || cart.isEmpty() ? "Your cart is empty" : "";
    }

    @Override
    public boolean isCheckoutButtonDisplayed() {
        return cart != null && !cart.isEmpty();
    }
}
