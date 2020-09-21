
package framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {


	protected AndroidDriver driver;
	protected WebDriverWait wait;

	public BasePage (AndroidDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}

	protected void waitAndClick (By by) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
	}

	protected void click (By by) {
		waitVisibility(by);
		driver.findElement(by).click();
	}

	protected void hideKeyboard(){
		driver.navigate().back();
	}
	


	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected List<WebElement> waitAndFindElements (By by) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	protected WebElement waitAndFindElement (By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	protected String getText(By by) {
		return waitAndFindElement(by).getText();
	}

	

	protected void assertEquals (String actual, String expected) {
		Assert.assertEquals(actual,expected, "Two texts are not equal!" + "Actual: " + actual + " Expected: " + expected);
	}

	protected void waitVisibility (By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}


	protected void sleep (long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void clickUsingTextContains(String txt) {


		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+txt+"\")")).click();


	}

	public boolean isElementPresentOnScreen (String txt) {
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+txt+"\")"))).isDisplayed();
	}

	protected void sendText (String text,String searchItemName) {		
	 wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+text+"\")"))).sendKeys(searchItemName);

	}
	
	public void pressKey() {
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	
	public void scrollTo() {
		
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width/2;
		int startx = (int)(height*0.5);
		int endy = (int)(height*0.2);
		TouchAction action = new TouchAction(driver);
	  action.press(PointOption.point(x,startx)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	  .moveTo(PointOption.point(x,endy)).release().perform();
		
	}
	
	
	
	public void tap(int x,int y) {
		
		TouchAction action = new TouchAction(driver);
		action.tap(TapOptions.tapOptions().withPosition(PointOption.point(x,y))).perform();
		
	}
	

}











