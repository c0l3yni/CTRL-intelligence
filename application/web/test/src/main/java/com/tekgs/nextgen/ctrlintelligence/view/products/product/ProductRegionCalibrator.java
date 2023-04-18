package com.tekgs.nextgen.ctrlintelligence.view.products.product;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ProductRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Product' Region";
    private final ProductRegionCalibratable expected;
    private final ProductRegionCalibratable actual;

    public ProductRegionCalibrator(ProductRegionCalibratable expected, ProductRegionCalibratable actual) {
        super(DESCRIPTION,expected, actual);
        this.expected=expected;
        this.actual=actual;
    }

    public static ProductRegionCalibrator getInstance(ProductRegionCalibratable expected, ProductRegionCalibratable actual) {
        return new ProductRegionCalibrator(expected,actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Name", expected.getName(), actual.getName());
        verify("Is 'Add to cart' displayed", expected.isButtonDisplayed(), actual.isButtonDisplayed());
        verify("'Out of Stock' message", expected.getOutOfStockMessage(), actual.getOutOfStockMessage());
        verify("Is 'Add to Cart' enabled ", expected.isAddToCartEnabled(), actual.isAddToCartEnabled());
    }

}