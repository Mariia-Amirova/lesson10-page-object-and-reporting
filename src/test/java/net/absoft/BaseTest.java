package net.absoft;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.absoft.data.Account;
import net.absoft.pages.InventoryPage;
import net.absoft.reporting.AttachmentUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import static org.testng.Assert.assertTrue;

public abstract class BaseTest {
  protected WebDriver driver;

  @BeforeSuite
  public void setUpChromeDriver() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeMethod
  public void initChromeDriver() {
    driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
  }

  @AfterMethod(alwaysRun = true)
  public void closeDriver(ITestResult result){
    if (!result.isSuccess()){
      AttachmentUtils.takeScreenshot(driver);
      AttachmentUtils.takePageSource(driver);
    }
    driver.quit();
  }
}
