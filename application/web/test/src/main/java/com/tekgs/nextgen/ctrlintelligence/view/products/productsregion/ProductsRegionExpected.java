package com.tekgs.nextgen.ctrlintelligence.view.products.productsregion;

import com.tekgs.nextgen.ctrlintelligence.data.inventory.product.CiProduct;
import com.tekgs.nextgen.ctrlintelligence.view.products.product.ProductRegionCalibratable;
import com.tekgs.nextgen.ctrlintelligence.view.products.product.ProductRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class ProductsRegionExpected implements ProductsRegionCalibratable{
    private final List<ProductRegionCalibratable> products = new ArrayList<>();

    public ProductsRegionExpected(List<CiProduct> products) {
        if(products != null){
            for(CiProduct product : products){
                this.products.add(ProductRegionExpected.getInstance(product));
            }
        }
    }

    public static ProductsRegionExpected getInstance(List<CiProduct> products) {
        return new ProductsRegionExpected(products);
    }

    @Override
    public List<ProductRegionCalibratable> getProducts() {
        return products;
    }
}
