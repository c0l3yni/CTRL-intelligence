package com.tekgs.nextgen.ctrlintelligence.view.cart;

import com.tekgs.nextgen.ctrlintelligence.data.cart.CiCart;
import com.tekgs.nextgen.ctrlintelligence.data.cart.CiCartDefinition;
import com.tekgs.nextgen.ctrlintelligence.data.cart.CiCartProvider;
import com.tekgs.nextgen.ctrlintelligence.data.cart.item.CiItemCalibratable;
import com.tekgs.nextgen.ctrlintelligence.data.cart.item.CiItemDefinition;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Test(groups = {GauntletTest.Application.CTRL_INTELLIGENCE, GauntletTest.View.CART})
public class CartViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        CiItemDefinition emptyName = CiItemDefinition.getInstance().withName("");
        CiItemDefinition spyPen = CiItemDefinition.getInstance().withName("Spy Pen");
        CiItemDefinition fiftyCharacterName = CiItemDefinition.getInstance().withName("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX");
        CiItemDefinition upperCaseToAscii = CiItemDefinition.getInstance().withName("083 080 089 032 067 065 077 069 082 065");
        CiItemDefinition sqlQueryName = CiItemDefinition.getInstance().withName("SELECT * FROM Users WHERE UserId = 2");
        CiItemDefinition nonDisplayableAsciiName = CiItemDefinition.getInstance().withName("(U+2408)");
        CiItemDefinition scriptName = CiItemDefinition.getInstance().withName("<script>Goku</script>");
        CiCartDefinition cartWithTwoItems = CiCartDefinition.getInstance().withItem(emptyName).withItem(spyPen);
        return new Object[][]{{CiCartDefinition.getInstance().withItem(emptyName)},
                {CiCartDefinition.getInstance().withItem(spyPen)}, {cartWithTwoItems},
                {CiCartDefinition.getInstance().withItem(fiftyCharacterName).withItem(upperCaseToAscii)},
                {CiCartDefinition.getInstance().withItem(sqlQueryName)},
                {CiCartDefinition.getInstance().withItem(nonDisplayableAsciiName).withItem(scriptName)},
                {CiCartDefinition.getInstance().withItemCount(0)}};
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("274 - Cart 'Checkout' Button");
        CartViewExpected expected = CartViewExpected.getInstance();
        CartView actual = CartView.directNav();
        then(CartViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.DEBUG}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(CiCartDefinition cartDefinition) {
        addRequirements("274 - Cart 'Checkout' Button");
        CiCart cart = CiCartProvider.getInstance().get(cartDefinition);
        given(cart);
        CartViewExpected expected = CartViewExpected.getInstance(cart);
        when();
        CartView actual = CartView.directNav(cart);
        then(CartViewCalibrator.getInstance(expected, actual));
    }
}
