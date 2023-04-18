package com.tekgs.nextgen.ctrlintelligence.view.products.productsregion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.ctrlintelligence.view.products.product.ProductRegion;
import com.tekgs.nextgen.ctrlintelligence.view.products.product.ProductRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class ProductsRegion extends UiRegion implements ProductsRegionCalibratable {
    private static final String DESCRIPTION = "'Products' Region ";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "products-region";

    private ProductsRegion(UiElement parentElement) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parentElement));
    }

    public static ProductsRegion getInstance(UiElement parent) {
        return new ProductsRegion(parent);
    }

    @Override
    public List<ProductRegionCalibratable> getProducts() {
        ArrayList<ProductRegionCalibratable> products = new ArrayList<>();
        for(UiElement productElement : UiElement.getList("Product", UiLocatorType.CLASS, "product", this.getElement())){
            products.add(ProductRegion.getInstance(productElement));
        }
        return products;
    }
}