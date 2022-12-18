package net.absoft;

import io.qameta.allure.Description;
import net.absoft.data.Account;
import net.absoft.data.Information;
import net.absoft.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductOrderTest extends BaseTest {

    Information information = Information.STANDARD_INFO_USER;
    private final String ITEM = "Sauce Labs Backpack";
    private ProductsPage productsPage;

    private CartPage cartPage;

    private InfoPage infoPage;

    private OverviewPage overviewPage;

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        productsPage = new LoginPage(driver).login(Account.STANDARD_USER);
        productsPage.shouldSeePrimaryHeader();
        productsPage.addItemToCart(ITEM);
        cartPage = productsPage.openCart();
        infoPage = cartPage.openInfoPage(ITEM);
    }

    @Description("Successful purchase")
    @Test
    public void testSuccessfulPurchase() {
        overviewPage = infoPage.enterInfo(information);
        checkoutPage = overviewPage.openCheckoutPage();
        checkoutPage.checkItemPresence();
    }
}
