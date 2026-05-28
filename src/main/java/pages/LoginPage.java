package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.WaitUtils;

public class LoginPage {

    WebDriver driver;

    WaitUtils waitUtil;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        waitUtil = new WaitUtils(driver);
    }

    // LOCATORS

    By signInBtn = By.id("signin");

    By usernameDropdown = By.id("username");

    By passwordDropdown = By.id("password");

    By loginBtn = By.id("login-btn");

    By ErrorMsg = By.xpath("//h3[text()='Invalid Username']");

    By usernameOption = By.xpath("//div[text()='demouser']");

    By passwordOption = By.xpath("//div[text()='testingisfun99']");

    // METHODS

    public void clickSignIn() {

        waitUtil.waitForElementClickable(signInBtn).click();
    }

    public void selectUsername() {

        waitUtil.waitForElementClickable(usernameDropdown)
                .click();

        waitUtil.waitForElementClickable(usernameOption)
                .click();
    }

    public void selectPassword() {

        waitUtil.waitForElementClickable(passwordDropdown)
                .click();

        waitUtil.waitForElementClickable(passwordOption)
                .click();
    }

    public void EnterUsernameAndPassword(
            String uname,
            String pwd) {

        Actions act = new Actions(driver);

        WebElement username =
                waitUtil.waitForElementClickable(
                        usernameDropdown);

        act.click(username)
           .sendKeys(uname)
           .perform();

        WebElement password =
                waitUtil.waitForElementClickable(
                        passwordDropdown);

        act.click(password)
           .sendKeys(pwd)
           .perform();
    }

    public void clickLogin() {

        waitUtil.waitForElementClickable(loginBtn)
                .click();
    }

    public String ErrorMessage() {

        return waitUtil.waitForElementVisible(ErrorMsg)
                .getText();
    }
}