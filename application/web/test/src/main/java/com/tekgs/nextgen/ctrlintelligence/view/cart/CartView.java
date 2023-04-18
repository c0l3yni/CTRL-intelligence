package com.tekgs.nextgen.ctrlintelligence.view.cart;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.ctrlintelligence.data.cart.CiCart;
import com.tekgs.nextgen.ctrlintelligence.view.cart.item.CiItemsRegion;
import com.tekgs.nextgen.ctrlintelligence.view.cart.item.CiItemsRegionCalibratable;
import org.softwareonpurpose.gauntlet.Environment;

public class CartView extends UiView implements CartViewCalibratable {
    private static final String LOCATOR_VALUE = "cart";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String DESCRIPTION = "'Cart' view";
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String VIEW_URI = String.format("%s/cart", DOMAIN_URL);

    public CartView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static CartView directNav() {
        new CartView().load();
        return UiView.expect(CartView.class);
    }

    public static CartView directNav(CiCart cart) {
        new CartView().load(String.format("?cart_id=%s", cart.getId()));
        return UiView.expect(CartView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    private UiElement getCartTotalElement() {
        return UiElement.getInstance("'Cart' total", UiLocatorType.ID, "cart-total", this.getElement());
    }

    @Override
    public String getCartTotal() {
        return getCartTotalElement().getText();
    }

    @Override
    public CiItemsRegionCalibratable inAllItemsRegion() {
        return CiItemsRegion.getInstance(this.getElement());
    }

    @Override
    public String getEmptyMessage() {
        return getEmptyMessageElement().getText();
    }

    private UiElement getEmptyMessageElement() {
        return UiElement.getInstance("'Cart' empty message", UiLocatorType.ID, "cart-empty-message", this.getElement());
    }

    private UiElement getCheckoutButtonElement(){
        return UiElement.getInstance("'Checkout' Button", UiLocatorType.CLASS, "checkout-button", this.getElement());
    }

    @Override
    public boolean isCheckoutButtonDisplayed() {
        return getCheckoutButtonElement().isDisplayed();
    }
}
