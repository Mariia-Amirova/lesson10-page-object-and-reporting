package net.absoft.pages;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class CheckoutPage extends BaseComponent{
    private final String itemXPath = "//div[@class='checkout_complete_container'][.//h2[@class='complete-header' and text()='THANK YOU FOR YOUR ORDER']]";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage checkItemPresence() {
        String itemXpathFormatted = String.format(itemXPath);
        assertTrue(
                driver.findElement(By.xpath(itemXpathFormatted)).isDisplayed(),
                "The order was not processed correctly. Purchase failed");
        return this;

    }
}
