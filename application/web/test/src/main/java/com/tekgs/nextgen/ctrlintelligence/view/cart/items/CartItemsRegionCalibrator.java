package com.tekgs.nextgen.ctrlintelligence.view.cart.items;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.ctrlintelligence.view.cart.item.CiItemRegionCalibratable;
import com.tekgs.nextgen.ctrlintelligence.view.cart.item.CiItemRegionCalibrator;
import com.tekgs.nextgen.ctrlintelligence.view.cart.item.CiItemsRegion;
import com.tekgs.nextgen.ctrlintelligence.view.cart.item.CiItemsRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class CartItemsRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Cart Items' region";

    private CartItemsRegionCalibrator(CiItemsRegionExpected expected, CiItemsRegion actual) {
        super(DESCRIPTION, expected, actual);
        addCartItemsCalibration(expected, actual);
    }

    public static CartItemsRegionCalibrator getInstance(CiItemsRegionExpected expected, CiItemsRegion actual) {
        return new CartItemsRegionCalibrator(expected, actual);
    }

    private void addCartItemsCalibration(CiItemsRegionExpected expected, CiItemsRegion actual) {
        UiRegion.suppressConstructionLogging(true);
        List<CiItemRegionCalibratable> expectedItems = expected.getItems();
        List<CiItemRegionCalibratable> actualItems = new ArrayList<>(actual.getItems());
        addItemCalibration(expectedItems, actualItems);
        UiRegion.suppressConstructionLogging(false);
    }

    private void addItemCalibration(List<CiItemRegionCalibratable> expectedItems, List<CiItemRegionCalibratable> actualItems) {
        for (CiItemRegionCalibratable itemExpected : expectedItems) {
            addExpectedCalibrations(actualItems, itemExpected);
        }
        addUnexpectedCalibrations(actualItems);
    }

    private void addExpectedCalibrations(List<CiItemRegionCalibratable> actualItems, CiItemRegionCalibratable itemExpected) {
        CiItemRegionCalibratable foundItem = null;
        for (CiItemRegionCalibratable itemActual : actualItems) {
            if (itemActual.equivalent(itemExpected)) {
                foundItem = itemActual;
                addChildCalibrator(CiItemRegionCalibrator.getInstance(itemExpected, itemActual));
                break;
            }
        }
        if (foundItem != null) {
            actualItems.remove(foundItem);
        } else {
            addChildCalibrator(CiItemRegionCalibrator.getInstance(itemExpected, null));
        }
    }

    private void addUnexpectedCalibrations(List<CiItemRegionCalibratable> actualItems) {
        for (CiItemRegionCalibratable unexpected : actualItems) {
            addChildCalibrator(CiItemRegionCalibrator.getInstance(null, unexpected));
        }
    }

    @Override
    protected void executeVerifications() {
    }
}
