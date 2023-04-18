package com.tekgs.nextgen.ctrlintelligence.view.products.product;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;


public class ProductRegion extends UiRegion implements ProductRegionCalibratable {
    private ProductRegion(UiElement regionElement) {
        super(regionElement);
    }

    public static ProductRegionCalibratable getInstance(UiElement productElement) {
        return new ProductRegion(productElement);
    }

    @Override
    public String getName() {
        return getNameElement().getText().trim();
    }

    private UiElement getNameElement() {
        return UiElement.getInstance("Name", UiLocatorType.CLASS, "product-name", this.getElement());
    }

    @Override
    public boolean equivalent(ProductRegionCalibratable comparator) {
        return comparator.getName() == null || this.getName().equals(comparator.getName());
    }

    @Override
    public Boolean isButtonDisplayed() {
        return getAddToCartElement().isDisplayed();
    }

    @Override
    public String getOutOfStockMessage() {
        return getOutOfStockElement().getText();
    }

    @Override
    public Boolean isAddToCartEnabled()  {
        return getAddToCartElement().getAttribute("disabled") == null;
    }

    private UiElement getOutOfStockElement(){
        return UiElement.getInstance("'Out of Stock' label", UiLocatorType.CLASS, "out-of-stock", this.getElement());
    }

    private UiElement getAddToCartElement() {
        return UiElement.getInstance("'Add to cart' button", UiLocatorType.CLASS, "add-to-cart", this.getElement());
    }
}