package net.absoft.pages;

import io.qameta.allure.Step;
import net.absoft.data.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BaseComponent {
  @FindBy(css = "input[data-test='username']")
  private WebElement usernameInput;
  @FindBy(css = "input[data-test='password']")
  private WebElement passwordInput;
  @FindBy(css = "input[data-test='login-button']")
  private WebElement loginButton;
  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Step("Perform login as {account.login} with password {account.password}")
  public ProductsPage login(Account account) {
    usernameInput.sendKeys(account.getLogin());
    passwordInput.sendKeys(account.getPassword());
    loginButton.click();
    return new ProductsPage(driver);
  }
}
