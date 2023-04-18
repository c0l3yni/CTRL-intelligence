package com.tekgs.nextgen.ctrlintelligence.view.products;

import com.tekgs.nextgen.ctrlintelligence.data.inventory.CiInventory;
import com.tekgs.nextgen.ctrlintelligence.data.inventory.CiInventoryProvider;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.CTRL_INTELLIGENCE, GauntletTest.View.PRODUCTS})
public class ProductsViewTests extends GauntletTest {
    @Test(groups = {})
    public void smoke() {
        addRequirements("110 - Products Page");
        addRequirements("109 - 'Products Page' add to cart button");
        addRequirements("107 - 'Products' out of stock");
        CiInventory inventory = CiInventoryProvider.getInstance().get();
        ProductsViewExpected expected = ProductsViewExpected.getInstance(inventory);
        when();
        ProductsView actual = ProductsView.directNav();
        then(ProductsViewCalibrator.getInstance(expected, actual));
    }
}
