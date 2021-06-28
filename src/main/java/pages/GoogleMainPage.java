package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleMainPage {

        public GoogleMainPage(AppiumDriver appiumDriver) {
            PageFactory.initElements(appiumDriver, this);
        }

        public static final String GoogleURL = "https://www.google.com/";

        @FindBy(xpath = "//*[@id='tsf']//input[@class='gLFyf']")
        private WebElement searchReq;

        @FindBy(css = "#center_col>#topstuff+div>#rso>div[data-hveid]")
        //@FindBy(xpath = "//*[@id='rso']//div/a")
        private List<WebElement> searchResults;


        public WebElement getSearchReq(){
                return searchReq;
        }

        public int getSearchResultListSize() {
                return searchResults.size();
        }

}
