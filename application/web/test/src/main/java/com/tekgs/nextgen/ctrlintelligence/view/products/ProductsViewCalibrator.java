package com.tekgs.nextgen.ctrlintelligence.view.products;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.ctrlintelligence.view.products.product.ProductRegionCalibratable;
import com.tekgs.nextgen.ctrlintelligence.view.products.product.ProductRegionCalibrator;

import java.util.ArrayList;
import java.util.List;

public class ProductsViewCalibrator extends Calibrator{
    private static final String DESCRIPTION =   "'Products' view" ;

    private ProductsViewCalibrator(ProductsViewExpected expected, ProductsView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addProductsCalibration(expected,actual);
        UiRegion.suppressConstructionLogging(false);
    }

    private void addProductsCalibration(ProductsViewExpected expected, ProductsView actual) {
        List<ProductRegionCalibratable> expectedItems = expected.inProductsRegion().getProducts();
        List<ProductRegionCalibratable> actualItems = new ArrayList<>(actual.inProductsRegion().getProducts());
        addProductCalibration(expectedItems,actualItems);
    }

    private void addProductCalibration(List<ProductRegionCalibratable> expectedItems, List<ProductRegionCalibratable> actualItems) {
        for(ProductRegionCalibratable itemExpected: expectedItems){
            addExpectedCalibrations(actualItems,itemExpected);
        }
        addUnexpectedCalibrations(actualItems);
    }

    private void addUnexpectedCalibrations(List<ProductRegionCalibratable> actualItems) {
        for(ProductRegionCalibratable unexpected: actualItems){
            addChildCalibrator(ProductRegionCalibrator.getInstance(null, unexpected));
        }
    }

    private void addExpectedCalibrations(List<ProductRegionCalibratable> actualItems, ProductRegionCalibratable itemExpected) {
        ProductRegionCalibratable foundItem = null;
        for(ProductRegionCalibratable itemActual: actualItems){
            if(itemActual.equivalent(itemExpected)){
                foundItem = itemActual;
                addChildCalibrator(ProductRegionCalibrator.getInstance(itemExpected,itemActual));
                break;
            }
        }
        if(foundItem!=null){
            actualItems.remove(foundItem);
        }else {
            addChildCalibrator(ProductRegionCalibrator.getInstance(itemExpected, null));
        }
    }

    public static ProductsViewCalibrator getInstance(ProductsViewExpected expected, ProductsView actual) {
        return new ProductsViewCalibrator(expected,actual);
    }

    @Override
    protected void executeVerifications() {}
}