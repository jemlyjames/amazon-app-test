package TestCases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test {

    static DesiredCapabilities capabilities;
    static AndroidDriver<AndroidElement> aDriver;

    public static void main(String[] args) throws MalformedURLException {






        File apkPath = new File("APK/Amazon_shopping.apk");

        DesiredCapabilities cap=new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"device");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.APP, apkPath.getAbsolutePath());
     //   cap.setCapability("appPackage", "com.amazon.mShop.android.shopping");
      //  cap.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
        cap.setCapability("autoGrantPermissions", true);
        URL url =new URL ("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);




    }









    



}
