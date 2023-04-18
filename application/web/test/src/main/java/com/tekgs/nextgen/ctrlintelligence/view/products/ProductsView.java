package com.tekgs.nextgen.ctrlintelligence.view.products;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.ctrlintelligence.view.products.productsregion.ProductsRegion;

public class ProductsView extends UiView implements ProductsViewCalibratable{
    private static final String DOMAIN_URL = "http://localhost:3000/products";
    private static final String DESCRIPTION = "'Products' view" ;
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "products";

    public ProductsView() {
        super(DOMAIN_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static ProductsView directNav() {
        new ProductsView().load();
        return UiView.expect(ProductsView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    @Override
    public ProductsRegion inProductsRegion() {
        return ProductsRegion.getInstance(this.getElement());
    }
}