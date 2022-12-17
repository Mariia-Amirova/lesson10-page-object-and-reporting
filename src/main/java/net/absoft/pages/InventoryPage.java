package net.absoft.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class InventoryPage extends BaseStorePage {

  private final String itemXPath = "//div[@class='inventory_item'][.//div[@class='inventory_item_name' and text()='%s']]";

  public InventoryPage(WebDriver driver) {
    super(driver);
  }
  @Step("Adding item {itemName} to cart")
  public InventoryPage addItemToCart(String itemName){
    WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
    WebElement addToCartButton = item.findElement(By.xpath("//button[contains(@data-test, 'add-to-cart')]"));
    addToCartButton.click();
    return this;
  }
  @Step("Remove item {itemName}")
  public InventoryPage removeItemFromCart(String itemName){
    WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
    WebElement removeButton = item.findElement(By.xpath("//button[contains(@data-test, 'remove-sauce-labs-backpack')]"));
    removeButton.click();
    return this;
  }

}
