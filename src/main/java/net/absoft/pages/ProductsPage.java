package net.absoft.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class ProductsPage extends BaseStorePage {

  private final String itemXPath = "//div[@class='inventory_item'][.//div[@class='inventory_item_name' and text()='%s']]";

  public ProductsPage(WebDriver driver) {
    super(driver);
  }
  @Step("Adding item {itemName} to cart")
  public ProductsPage addItemToCart(String itemName){
    WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
    WebElement addToCartButton = item.findElement(By.xpath("//button[contains(@data-test, 'add-to-cart')]"));
    addToCartButton.click();
    return this;
  }
  @Step("Remove item {itemName}")
  public ProductsPage removeItem(String itemName){
    WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
    WebElement removeButton = item.findElement(By.xpath("//button[contains(@data-test, 'remove-sauce-labs-backpack')]"));
    removeButton.click();
    return this;
  }

}
