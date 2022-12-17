package net.absoft.components;

import static org.testng.Assert.assertTrue;

import net.absoft.data.Account;
import net.absoft.pages.BaseComponent;
import net.absoft.pages.CartPage;
import net.absoft.pages.InventoryPage;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrimaryHeader extends BaseComponent {

  public  final By SHOPPING_CART_LINK = By.cssSelector("a.shopping_cart_link");

  public PrimaryHeader(WebDriver driver) {
    super(driver);
  }

  public PrimaryHeader shouldSeePrimaryHeader() {
    assertTrue(ObjectUtils.isNotEmpty(driver.findElements(SHOPPING_CART_LINK))
                    && driver.findElement(SHOPPING_CART_LINK).isDisplayed(),
            "User" + Account.STANDARD_USER + "wasn't logged in");
    return this;
  }

  public CartPage openCart() {
    driver.findElement(SHOPPING_CART_LINK).click();
    return new CartPage(driver);
  }
}
