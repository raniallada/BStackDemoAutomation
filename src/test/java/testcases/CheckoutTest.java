package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {
	
	@Test
	public void verifyPlaceOrder() throws InterruptedException {
		
		test = extent.createTest("TC_007: Place order with valid details");
		
       LoginPage lp = new LoginPage(driver);
    	
    	lp.clickSignIn();
    	
    	lp.selectUsername();
    
    	lp.selectPassword();
    
    	lp.clickLogin();
    	
		
		ProductPage product = new ProductPage(driver);
		
		product.addMultipleProducts(3);
		
		CheckoutPage checkout = new CheckoutPage(driver);
	
		checkout.clickCheckout();
		
		checkout.enterShippingDetails("Rani", "Allada", "1-98/a", "HYderabad", "500034");
	
		checkout.clickSubmit();
		
		String actualmsg = checkout.successMessage();
		
		Assert.assertTrue(actualmsg.contains("successfully placed"));

        System.out.println("Order Placed Successfully");
		
	}
	
	@Test
	public void verifyCheckoutWithoutItems() throws InterruptedException {
		
		test = extent.createTest("TC_008: Checkout flow without adding items (negative test)");

		ProductPage product = new ProductPage(driver);

	    product.addSingleProduct();

	    product.removeProduct();
	   
	    String actualMessage = product.emptyCartMessage();
	    
	    Assert.assertTrue(actualMessage.contains("Add some products"));

	    System.out.println("Checkout Negative Validation Successful");
	}
	
	
	
	
}
