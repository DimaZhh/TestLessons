package uitests;

import static org.ui.constants.Errors.EXPECTED_ERROR_LOGIN_TEXT;
import static org.testng.Assert.assertEquals;

import org.ui.BaseUiTestClass;
import org.ui.pages.SauceLoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTests extends BaseUiTestClass {

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
