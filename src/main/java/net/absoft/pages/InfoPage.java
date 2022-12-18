package net.absoft.pages;

import io.qameta.allure.Step;
import net.absoft.data.Account;
import net.absoft.data.Information;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfoPage extends BaseComponent {
    @FindBy(css = "input[data-test='firstName']")
    private WebElement firstName;
    @FindBy(css = "input[data-test='lastName']")
    private WebElement lastName;
    @FindBy(css = "input[data-test='postalCode']")
    private WebElement postalCode;
    @FindBy(css = "input[data-test='continue']")
    private WebElement continueButton;
    public InfoPage(WebDriver driver) {super(driver);}

    @Step("Enter information as {information.firstName} , {information.lastName} , {information.postalCode} ")
    public OverviewPage enterInfo(Information information) {
        firstName.sendKeys(information.getFirstName());
        lastName.sendKeys(information.getLastName());
        postalCode.sendKeys(information.getPostalCode());
        continueButton.click();
        return new OverviewPage(driver);
    }
}
