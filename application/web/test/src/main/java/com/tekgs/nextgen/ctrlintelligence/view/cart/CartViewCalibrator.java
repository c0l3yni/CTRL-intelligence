package com.tekgs.nextgen.ctrlintelligence.view.cart;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.ctrlintelligence.view.cart.item.CiItemRegionCalibratable;
import com.tekgs.nextgen.ctrlintelligence.view.cart.item.CiItemRegionCalibrator;

import java.util.ArrayList;
import java.util.List;

public class CartViewCalibrator extends Calibrator {

    private static final String DESCRIPTION = "'Cart' view";
    private final CartViewExpected expected;
    private final CartView actual;

    private CartViewCalibrator(CartViewExpected expected, CartView actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
        addCartItemsCalibration(expected, actual);
    }

    private void addCartItemsCalibration(CartViewExpected expected, CartView actual) {
        UiRegion.suppressConstructionLogging(true);
        List<CiItemRegionCalibratable> expectedItems = expected.inAllItemsRegion().getItems();
        List<CiItemRegionCalibratable> actualItems = new ArrayList<>(actual.inAllItemsRegion().getItems());
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

    public static CartViewCalibrator getInstance(CartViewExpected expected, CartView actual) {
        return new CartViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Cart' Total", expected.getCartTotal(), actual.getCartTotal());
        verify("'Cart' empty message", expected.getEmptyMessage(), actual.getEmptyMessage());
        verify("'Checkout' button displayed", expected.isCheckoutButtonDisplayed(), actual.isCheckoutButtonDisplayed());
    }
}
