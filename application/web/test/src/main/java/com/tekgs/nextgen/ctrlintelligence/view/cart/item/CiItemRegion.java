package com.tekgs.nextgen.ctrlintelligence.view.cart.item;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public class CiItemRegion extends UiRegion implements CiItemRegionCalibratable {
    private CiItemRegion(UiElement itemElement) {
        super(itemElement);
    }

    public static CiItemRegion getInstance(UiElement itemElement) {
        return new CiItemRegion(itemElement);
    }

    @Override
    public boolean equivalent(CiItemRegionCalibratable comparator) {
        return comparator.getName() == null || this.getName().equals(comparator.getName());
    }

    @Override
    public boolean isRemoveItemButtonDisplayed() {
        return getRemoveButtonElement().isDisplayed();
    }

    private UiElement getRemoveButtonElement() {
        return UiElement.getInstance("Remove Button", UiLocatorType.CLASS, "remove-button", this.getElement());
    }

    @Override
    public String getName() {
        return getNameElement().getText();
    }

    private UiElement getNameElement() {
        return UiElement.getInstance("Name", UiLocatorType.CLASS, "item-name", this.getElement());
    }

    @Override
    public String getItemQuantity() {
        return getItemQuantityElement().getText();
    }

    @Override
    public String getSubtotal() {
        return getItemSubtotalElement().getText();
    }

    private UiElement getItemSubtotalElement(){
        return UiElement.getInstance("Item Subtotal", UiLocatorType.CLASS, "item-subtotal", this.getElement());
    }

    private UiElement getItemQuantityElement() {
        return UiElement.getInstance("Item Quantity", UiLocatorType.CLASS, "item-quantity", this.getElement());
    }
}
