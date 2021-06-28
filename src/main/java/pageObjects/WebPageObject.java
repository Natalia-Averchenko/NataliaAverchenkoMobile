package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import pages.GoogleMainPage;

public class WebPageObject  {

    public GoogleMainPage googleMainPage;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
        this.googleMainPage = new GoogleMainPage(appiumDriver);
    }
}
