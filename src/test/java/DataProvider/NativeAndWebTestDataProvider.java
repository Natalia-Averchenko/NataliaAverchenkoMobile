package DataProvider;

import org.testng.annotations.DataProvider;

public class NativeAndWebTestDataProvider {

    private static final String email = "natalia_ave@epam.com";
    private static final String username = "Natalia";
    private static final String password = "!Natasha123456";
    private static final String keyword = "EPAM";

    @DataProvider
    public Object[][] dataNativeTest() {
        return new Object[][]{
                {email, username, password}
        };
    }

    @DataProvider
    public Object[][] dataWebTest() {
        return new Object[][]{
                {keyword}
        };
    }

}
