package com.tekgs.nextgen.ctrlintelligence.view.products;

import com.tekgs.nextgen.ctrlintelligence.data.inventory.CiInventory;
import com.tekgs.nextgen.ctrlintelligence.view.products.productsregion.ProductsRegionExpected;

import java.util.ArrayList;

public class ProductsViewExpected implements ProductsViewCalibratable{
    private final CiInventory inventory;

    public ProductsViewExpected(CiInventory inventory) {
        this.inventory=inventory;
    }

    public static ProductsViewExpected getInstance(CiInventory inventory) {
        return new ProductsViewExpected(inventory);
    }

    public static ProductsViewExpected getInstance() {
        return new ProductsViewExpected(null);
    }

    @Override
    public ProductsRegionExpected inProductsRegion() {
        return inventory == null ?  ProductsRegionExpected.getInstance(new ArrayList<>()):  ProductsRegionExpected.getInstance(inventory.getProducts());
    }
}
