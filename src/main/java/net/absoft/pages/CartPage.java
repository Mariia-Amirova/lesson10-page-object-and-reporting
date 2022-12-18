package net.absoft.pages;

import static org.testng.Assert.assertTrue;

import io.qameta.allure.Step;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BaseStorePage {
  private final String itemXPath = "//div[@class='cart_item'][.//div[@class='inventory_item_name' and text()='%s']]";
  private final String titleXPath = "//div[@class='header_secondary_container'][.//span[@class='title' and text()='Checkout: Your Information']]";

  public CartPage(WebDriver driver) {
    super(driver);
  }


  public CartPage checkItemPresence(String itemName) {
    String itemXpathFormatted = String.format(itemXPath, itemName);
    assertTrue(
            ObjectUtils.isNotEmpty(driver.findElements(By.xpath(itemXpathFormatted)))
                    && driver.findElement(By.xpath(itemXpathFormatted)).isDisplayed(),
            "Item" + itemName + "wasn't added to cart");
    return this;

  }

  public CartPage checkItemNotPresence(String itemName) {
    String itemXpathFormatted = String.format(itemXPath, itemName);
    assertTrue(
            ObjectUtils.isEmpty(driver.findElements(By.xpath(itemXpathFormatted))),
            "Item" + itemName + "wasn't removed from cart");
    return this;
  }
  @Step("Remove item {itemName}")
  public CartPage removeItem(String itemName){
    WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
    WebElement removeButton = item.findElement(By.xpath("//button[contains(@data-test, 'remove-sauce-labs-backpack')]"));
    removeButton.click();
    return this;
  }

  @Step("Click on the checkoutButton")
  public InfoPage openInfoPage(String titleName){
    WebElement title = driver.findElement(By.xpath(String.format(itemXPath, titleName)));
    WebElement checkoutButton = title.findElement(By.xpath("//button[contains(@data-test, 'checkout')]"));
    checkoutButton.click();
    return new InfoPage (driver);
  }

}
