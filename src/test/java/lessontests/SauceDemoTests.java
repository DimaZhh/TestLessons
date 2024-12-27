package lessontests;

import static org.constants.Errors.EXPECTED_ERROR_LOGIN_TEXT;
import static org.testng.Assert.assertEquals;

import org.pages.SauceLoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTests extends BaseTestClass {

    SauceLoginPage sauceLoginPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        getDriver().get(getReadPropertyFile().getPropertyByValue("default.url"));
        sauceLoginPage = new SauceLoginPage(getDriver());
    }

    @Test
    public void checkLoginExceptionErrorTextDetails() {
        String actualErrorText = sauceLoginPage.loginWithWrongCredentialsAndGetErrorText();
        assertEquals(actualErrorText, EXPECTED_ERROR_LOGIN_TEXT);
    }
}
