package scenarios;

import DataProvider.NativeAndWebTestDataProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import setup.BaseTest;

import static org.testng.Assert.assertTrue;
import static pages.GoogleMainPage.GoogleURL;

public class webMobileTests extends BaseTest {

   /* @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
    public void simpleWebTest() throws InterruptedException {
        getDriver().get("http://iana.org"); // open IANA homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check IANA homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Internet Assigned Numbers Authority") : "This is not IANA homepage";

        // Log that test finished
        System.out.println("Site opening done");
    } */


    @Test(groups = {"web"}, description = "Make sure that we can get relevant result by searching 'EPAM'",
            dataProviderClass = NativeAndWebTestDataProvider.class,
            dataProvider = "dataWebTest")
    public void simpleWebTest(String keyword) throws InterruptedException, IllegalAccessException, NoSuchFieldException, InstantiationException {

        GoogleMainPage googleMainPage = new GoogleMainPage(getDriver());
        getDriver().get(GoogleURL);

        googleMainPage.getSearchReq().sendKeys(keyword);
        googleMainPage.getSearchReq().sendKeys(Keys.ENTER);

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

        assertTrue(googleMainPage.getSearchResultListSize()>0);

        // Log that test finished
        System.out.println("Google search test completed");
    }

}
