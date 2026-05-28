package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class CheckoutPage {

    WebDriver driver;

    WaitUtils waitUtil;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

        waitUtil = new WaitUtils(driver);
    }

    // LOCATORS

    By checkoutBtn = By.className("buy-btn");

    By firstNameInput = By.id("firstNameInput");

    By lastNameInput = By.id("lastNameInput");

    By address = By.id("addressLine1Input");

    By provinceInput = By.id("provinceInput");

    By postCodeInput = By.id("postCodeInput");

    By submitButton = By.xpath("//button[@type='submit']");

    By confirmationMsg =
            By.xpath("//legend[@id='confirmation-message']");

    By cart = By.xpath("//span[@class='bag']");

    By emptyCartMessage =
            By.xpath("//p[contains(text(),'Add some products')]");

    // METHODS

    public void clickCheckout() {

        waitUtil.waitForElementClickable(checkoutBtn)
                .click();
    }

    public void enterShippingDetails(
            String Fname,
            String Lname,
            String add1,
            String state,
            String PostalCode) {

        waitUtil.waitForElementVisible(firstNameInput)
                .sendKeys(Fname);

        waitUtil.waitForElementVisible(lastNameInput)
                .sendKeys(Lname);

        waitUtil.waitForElementVisible(address)
                .sendKeys(add1);

        waitUtil.waitForElementVisible(provinceInput)
                .sendKeys(state);

        waitUtil.waitForElementVisible(postCodeInput)
                .sendKeys(PostalCode);
    }

    public void clickSubmit() {

        waitUtil.waitForElementClickable(submitButton)
                .click();
    }

    public String successMessage() {

        return waitUtil.waitForElementVisible(
                confirmationMsg)
                .getText();
    }

    public void clickCart() {

        waitUtil.waitForElementClickable(cart)
                .click();
    }

    public String getEmptyCartMessage() {

        return waitUtil.waitForElementVisible(
                emptyCartMessage)
                .getText();
    }
}