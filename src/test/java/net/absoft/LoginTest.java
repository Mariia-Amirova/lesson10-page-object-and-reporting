package net.absoft;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import net.absoft.data.Account;
import net.absoft.pages.ProductsPage;
import net.absoft.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  private ProductsPage productsPage;
  Account account = Account.STANDARD_USER;

  @Test(description = "Test successful Login")
  public void testSuccessfulLogin() {
    productsPage = new LoginPage(driver).login(Account.STANDARD_USER);
    productsPage.shouldSeePrimaryHeader();
  }
}
