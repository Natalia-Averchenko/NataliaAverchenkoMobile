package scenarios;

import DataProvider.NativeAndWebTestDataProvider;
import org.testng.annotations.Test;
import setup.BaseTest;

import static org.testng.Assert.assertTrue;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "Check log in after creating new user",
            dataProviderClass = NativeAndWebTestDataProvider.class,
            dataProvider = "dataNativeTest")
    public void simpleNativeTest(String email, String username, String password) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("registerBtn").click();
        getPo().getWelement("registrationEmail").sendKeys(email);
        getPo().getWelement("registrationUserName").sendKeys(username);
        getPo().getWelement("registrationPassword").sendKeys(password);
        getPo().getWelement("confirmPassword").sendKeys(password);
        getPo().getWelement("newAccountBtn").click();

        getPo().getWelement("loginEmail").sendKeys(email);
        getPo().getWelement("password").sendKeys(password);
        getPo().getWelement("signInBtn").click();

        assertTrue(getPo().getWelement("newExpenseBtn").isDisplayed());
        System.out.println("Simplest Android native test done");

    }

}
