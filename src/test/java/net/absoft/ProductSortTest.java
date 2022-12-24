package net.absoft;

import io.qameta.allure.Description;
import net.absoft.data.Account;
import net.absoft.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductSortTest extends BaseTest {
    private ProductsPage productsPage;


    @BeforeMethod
    public void setUp() {
        productsPage = new LoginPage(driver).login(Account.STANDARD_USER);
        productsPage.shouldSeePrimaryHeader();
    }



    @Description("Filter check <Name A to Z>")
    @Test
    public void testSortNameAtoZ() {
        List<String> cardNamesDisplayed = productsPage.sortNameAtoZ().getCardNames();
        List<String> sortCardNames = new ArrayList<>(cardNamesDisplayed);
        Collections.sort(sortCardNames);
        Assert.assertEquals(cardNamesDisplayed, sortCardNames);
    }

    @Description("Filter check <Name Z to A>")
    @Test
    public void testSortNameZtoA() {
        List<String> cardNamesDisplayed = productsPage.sortNameZtoA().getCardNames();
        List<String> sortCardNames = new ArrayList<>(cardNamesDisplayed);
        Collections.sort(sortCardNames, Collections.reverseOrder());
        Assert.assertEquals(cardNamesDisplayed, sortCardNames);
    }

    @Description("Filter check <Price High to Low>")
    @Test
    public void testSortPriceHightoLow() {
        List<Double> cardPrices = productsPage.sortPriceHightoLow().getCardPrices();
        List<Double> sortCardPrices = new ArrayList<>(cardPrices);
        Collections.sort(sortCardPrices, Collections.reverseOrder());
        Assert.assertEquals(cardPrices, sortCardPrices);
    }

    @Description("Filter check <Price Low to High>")
    @Test
    public void testSortPriceLowtoHigh() {
        List<Double> cardPrices = productsPage.sortPriceLowtoHigh().getCardPrices();
        List<Double> sortCardPrices = new ArrayList<>(cardPrices);
        Collections.sort(sortCardPrices);
        Assert.assertEquals(cardPrices, sortCardPrices);
    }

}
