package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;


import base.BaseTest;
import pages.ProductPage;

public class AddToCartTest extends BaseTest{
	

	@Test(priority=1)
	public void verifyAddSingleItemToCart() throws InterruptedException {
		
		test = extent.createTest("TC_004: Add single item to cart");
		
		ProductPage product = new ProductPage(driver);
	
		product.addSingleProduct();
		
		String actualCount  = product.getCartCount();
		
		Assert.assertEquals(actualCount, "1");
		
	
		System.out.println("Single Product Added Successfully");
		
	}
	
	@Test(priority = 2)
	public void verifyAddMultipleItemsToCart() throws InterruptedException {
		
		test = extent.createTest("TC_005: Add multiple items to cart and verify cart count");
		
		ProductPage product = new ProductPage(driver);
		
		product.addMultipleProducts(6);
		
		String actualCount  = product.getCartCount();
		
		Assert.assertEquals(actualCount, "6");
		
	
		System.out.println("Multiple Products Added Successfully");
		 
		
		
	}
	
	@Test(priority = 3)
	public void verifyRemoveProductFromCart() throws InterruptedException {
		
		test = extent.createTest("TC_006: Remove item from cart");

	    ProductPage product = new ProductPage(driver);

	

	    product.addSingleProduct();

	    product.removeProduct();

	    String actualMessage = product.emptyCartMessage();
	    

	    Assert.assertTrue(actualMessage.contains("Add some products"));

	    System.out.println("Product Removed Successfully");
	}
	
}
