package com.tekgs.nextgen.ctrlintelligence.view.products.product;

import com.tekgs.nextgen.ctrlintelligence.data.inventory.product.CiProduct;

public class ProductRegionExpected implements ProductRegionCalibratable {
    private final CiProduct product;
    private ProductRegionCopy copy;

    public ProductRegionExpected(CiProduct product) {
        this.product = product;
    }

    public static ProductRegionExpected getInstance(CiProduct product) {
        return new ProductRegionExpected(product);
    }

    @Override
    public String getName() {
        return truncateName(product.getName().trim());
    }

    private String truncateName(String name) {
        if (name.length() > 256) {
            return name.substring(0, 253) + "...";
        } else {
            return name;
        }
    }

    @Override
    public boolean equivalent(ProductRegionCalibratable comparator) {
        return false;
    }

    @Override
    public Boolean isButtonDisplayed() {
        return true;
    }

    @Override
    public String getOutOfStockMessage() {
        return isInStock() ? "" : getCopy().getOutOfStock();
    }

    private ProductRegionCopy getCopy() {
        if(copy==null){
            copy = ProductRegionCopy.getInstance();
        }
        return copy;
    }

    @Override
    public Boolean isAddToCartEnabled() {
        return isInStock();
    }

    private boolean isInStock() {
        return product.getQuantity() > 0;
    }
}
