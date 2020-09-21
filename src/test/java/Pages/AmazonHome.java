package Pages;

import java.util.concurrent.TimeUnit;

import framework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AmazonHome extends BasePage {

	public AmazonHome(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	
	
	/*
	 * All locators related to this class
	 */
	
	
	public void searchItemInSearchBox() {
		
		clickUsingTextContains("Search");
		sendText("Search", "65 inch TV");
		pressKey();
		
		
		
	}
	
	public void selectAnItemFromSearchList() throws InterruptedException {
		
		TimeUnit.SECONDS.sleep(7);
		scrollTo();
		clickUsingTextContains("65 Inches");
		tap(0, 1283);
		
	}
	
	
	

}
