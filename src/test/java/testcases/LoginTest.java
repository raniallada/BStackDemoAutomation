package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority=1)
    public void verifyTitle() {

        String actualTitle = driver.getTitle();

        System.out.println("Page Title is: " + actualTitle);
    }
    
    @Test(priority=2)
    public void verifyValidLogin() throws InterruptedException  {
    	
    	test = extent.createTest("TC_001: Login with valid credentials");
    	
    	LoginPage lp = new LoginPage(driver);
    	
    	lp.clickSignIn();
    	
    	lp.selectUsername();
    
    	lp.selectPassword();
    
    	lp.clickLogin();
    
    	String currentUrl = driver.getCurrentUrl();

    	String expectedUrl = "https://bstackdemo.com/signin";

    	Assert.assertEquals(currentUrl, expectedUrl);

    	System.out.println("Login Successful");
    	
    }
    
    @Test(priority=3)
    public void verifyInvalidLogin() {
    	
    	test = extent.createTest("TC_002: Login with invalid credentials");
    	
    	LoginPage lp = new LoginPage(driver);
    	lp.clickSignIn();
    	
    	lp.EnterUsernameAndPassword("abc", "xyz");
    	lp.clickLogin();
    	
    	String ErrMsg = lp.ErrorMessage();
    	Assert.assertEquals(ErrMsg, "Invalid Username");
    	
    	System.out.println("Invalid Login Validation Successful");
    	
    	
    }
    
    @Test(priority=4)
    public void verifyEmptyCredentials() {
    	
    	test = extent.createTest("TC_003: Login with empty username/password");
    	
    	LoginPage lp = new LoginPage(driver);
    	
    	lp.clickSignIn();
    	
    	lp.clickLogin();
    	
    	String ErrMsg = lp.ErrorMessage();
    	Assert.assertEquals(ErrMsg, "Invalid Username");
    	
    	System.out.println("Empty Credential login Validation Successful");
    }
    
    
}