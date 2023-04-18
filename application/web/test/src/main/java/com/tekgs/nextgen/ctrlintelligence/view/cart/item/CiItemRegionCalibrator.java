package com.tekgs.nextgen.ctrlintelligence.view.cart.item;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class CiItemRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Item' region";
    private final CiItemRegionCalibratable expected;
    private final CiItemRegionCalibratable actual;

    private CiItemRegionCalibrator(CiItemRegionCalibratable expected, CiItemRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static CiItemRegionCalibrator getInstance(CiItemRegionCalibratable expected, CiItemRegionCalibratable actual) {
        return new CiItemRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Name", expected.getName(), actual.getName());
        verify("Remove Button", expected.isRemoveItemButtonDisplayed(), actual.isRemoveItemButtonDisplayed());
        verify("Item Quantity", expected.getItemQuantity(), actual.getItemQuantity());
        verify("Item Subtotal", expected.getSubtotal(), actual.getSubtotal());
    }
}
