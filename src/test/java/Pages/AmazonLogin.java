package Pages;

import framework.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class AmazonLogin extends BasePage{






	public AmazonLogin(@SuppressWarnings("rawtypes") AndroidDriver driver) {
		super(driver);
	}



	//Mobile Elements
	String  skipSignInBtnName ="com.amazon.mShop.android.shopping:id/skip_sign_in_button";




	/*
	 * This method will click on skipSginBtn
	 */
	public void skipSignIn() {

		clickUsingTextContains("Skip");
		//waitAndClick(By.id(skipSignInBtnName));
	}
	
	
	








}
