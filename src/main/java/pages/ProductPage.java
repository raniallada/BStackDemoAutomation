package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public class ProductPage {

    WebDriver driver;

    WaitUtils waitUtil;

    public ProductPage(WebDriver driver) {

        this.driver = driver;

        waitUtil = new WaitUtils(driver);
    }

    // LOCATORS

    By singleItem =
            By.xpath("//div[@class='shelf-item__buy-btn']");

    By cartCount = By.className("bag__quantity");

    By removeBtn =
            By.xpath("//div[@class='shelf-item__del']");

    By emptyCart =
            By.xpath("//p[contains(text(),'Add some products')]");

    // METHODS

    public void addSingleProduct() {

        waitUtil.waitForElementClickable(singleItem)
                .click();
    }

    public void addMultipleProducts(int productnum) {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        for (int i = 1; i <= productnum; i++) {

            WebElement product =
                    driver.findElement(
                            By.xpath(
                                    "(//div[@class='shelf-item__buy-btn'])["
                                            + i + "]"));

            js.executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    product);

            js.executeScript(
                    "arguments[0].click();",
                    product);
        }
    }

    public String getCartCount() {

        return waitUtil.waitForElementVisible(cartCount)
                .getText();
    }

    public void removeProduct() {

        waitUtil.waitForElementClickable(removeBtn)
                .click();
    }

    public String emptyCartMessage() {

        return waitUtil.waitForElementVisible(emptyCart)
                .getText();
    }
}