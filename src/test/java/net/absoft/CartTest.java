package net.absoft;

import io.qameta.allure.Description;
import net.absoft.data.Account;
import net.absoft.pages.ProductsPage;
import net.absoft.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {
    private final String ITEM = "Sauce Labs Backpack";
    private ProductsPage productsPage;


    @BeforeMethod
    public void setUp() {
        new LoginPage(driver)
                .login(Account.STANDARD_USER)
                .shouldSeePrimaryHeader();
        productsPage = new ProductsPage(driver);
    }

    @Description("Test adding item to cart")
    @Test
    public void testAddingItemToCart() {
        productsPage
                .addItemToCart(ITEM)
                .openCart()
                .checkItemPresence(ITEM);
    }

    @Description("Test removing item from products page")
    @Test
    public void testRemovingItemFromProducts() {
        productsPage
                .addItemToCart(ITEM)
                .removeItem(ITEM)
                .openCart()
                .checkItemNotPresence(ITEM);
    }
    @Description("Test removing item from cart page")
    @Test
    public void testRemovingItemFromCart() {
        productsPage
                .addItemToCart(ITEM)
                .openCart()
                .removeItem(ITEM)
                .checkItemNotPresence(ITEM);
    }
}
