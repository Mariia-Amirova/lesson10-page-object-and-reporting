package net.absoft.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ProductsPage extends BaseStorePage {

    private final String itemXPath = "//div[@class='inventory_item'][.//div[@class='inventory_item_name' and text()='%s']]";
    private final String productSortXPath = "//select[@class='product_sort_container']";


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Adding item {itemName} to cart")
    public ProductsPage addItemToCart(String itemName) {
        WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
        WebElement addToCartButton = item.findElement(By.xpath("//button[contains(@data-test, 'add-to-cart')]"));
        addToCartButton.click();
        return this;
    }

    @Step("Remove item {itemName}")
    public ProductsPage removeItem(String itemName) {
        WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
        WebElement removeButton = item.findElement(By.xpath("//button[contains(@data-test, 'remove-sauce-labs-backpack')]"));
        removeButton.click();
        return this;
    }


    @Step("Sort products name A to Z")
    public ProductsPage sortNameAtoZ() {
        WebElement productSort = driver.findElement(By.xpath(productSortXPath));
        Select select = new Select(productSort);
        select.selectByValue("az");
        return this;
    }

    @Step("Sort products name Z to A")
    public ProductsPage sortNameZtoA() {
        WebElement productSort = driver.findElement(By.xpath(productSortXPath));
        Select select = new Select(productSort);
        select.selectByValue("za");
        return this;
    }

    @Step("Sort products price low to high")
    public ProductsPage sortPriceLowtoHigh() {
        WebElement productSort = driver.findElement(By.xpath(productSortXPath));
        Select select = new Select(productSort);
        select.selectByValue("lohi");
        return this;
    }

    @Step("Sort products price high to low")
    public ProductsPage sortPriceHightoLow() {
        WebElement productSort = driver.findElement(By.xpath(productSortXPath));
        Select select = new Select(productSort);
        select.selectByValue("hilo");
        return this;
    }

    public List<String> getCardNames() {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> names = new ArrayList<>();
        for (WebElement e : items) {
            names.add(e.getText());
        }
        return names;
    }

    public List<Double> getCardPrices() {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> prices = new ArrayList<>();
        for (WebElement e : items) {
            prices.add(Double.valueOf(e.getText().replace("$","")));
        }
        return prices;
    }
}
