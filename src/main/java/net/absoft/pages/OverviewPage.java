package net.absoft.pages;

import io.qameta.allure.Step;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class OverviewPage extends BaseStorePage {
    private final String titleXPath = "//div[@class='header_secondary_container'][.//span[@class='title' and text()='Checkout: Overview']]";

    public OverviewPage(WebDriver driver) {
        super(driver);
    }


    @Step("Click on the finishButton")
    public CheckoutPage openCheckoutPage() {
        WebElement title = driver.findElement(By.xpath(titleXPath));
        WebElement finishButton = title.findElement(By.xpath("//button[contains(@data-test, 'finish')]"));
        finishButton.click();
        return new CheckoutPage(driver);
    }

}
