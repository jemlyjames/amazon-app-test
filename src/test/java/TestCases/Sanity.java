package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.AmazonHome;
import Pages.AmazonLogin;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Sanity extends Driver{


	@Test(priority = 1)
	public void validateAmazonLoginPage() throws InterruptedException {

		AmazonLogin login = new AmazonLogin(aDriver);

		login.skipSignIn();
		Assert.assertTrue(login.isElementPresentOnScreen("amazon"));

	}
	
	@Test(priority = 2)
	public void validateSearchResutInAmazonSearchPage() throws InterruptedException {
		
		AmazonHome home = new AmazonHome(aDriver);
		home.searchItemInSearchBox();
		home.selectAnItemFromSearchList();
		
		
		home.get_Name_Price_Description();
		
	}



}
