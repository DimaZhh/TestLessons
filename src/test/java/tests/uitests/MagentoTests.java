package tests.uitests;

import static org.ui.constants.ExpectedButtonText.WATCHES_BUTTON_EXPECTED_TEXT;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.ui.BaseUiTestClass;
import org.ui.pages.LumaLandingPage;
import org.ui.pages.LumaWatchesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MagentoTests extends BaseUiTestClass {

    private LumaLandingPage lumaLandingPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        getDriver().get(getReadPropertyFile().getPropertyByValue("specific.url"));
        lumaLandingPage = new LumaLandingPage(getDriver());
    }

    @Test
    public void checkDropDownsOnLandingPage() {
        LumaWatchesPage lumaWatchesPage = lumaLandingPage
                .clickOnDropDownGearWatches(getDriver(), getActions(), getWaiters());
        String actualText = lumaWatchesPage.getTitleWrapperText(getDriver());
        assertEquals(actualText, WATCHES_BUTTON_EXPECTED_TEXT);
    }

    @Test
    public void checkAllMandatoryCategoriesOnLandingPage() {
        List<WebElement> elements = lumaLandingPage.getAllTopLineWebElements(getWaiters(), getDriver());
        assertEquals(elements.size(), 6,
                "Number of elements in the gear dropdown is not as expected");
    }

    @Test
    public void checkLinksArePresentInCategoriesOnLandingPage() {
        String link = lumaLandingPage.getLink(getDriver());
        getDriver().switchTo().newWindow(WindowType.TAB).get(link);
    }

    @Test(enabled = false)
    public void checkNewIFramePresentationOnLandingPage() {
        lumaLandingPage.findAndSwitchToIFrame(getDriver());
        getWaiters().waitUntilVisible(getDriver(), lumaLandingPage.mySwapper, 10);
        assertNotNull(lumaLandingPage.mySwapper);
    }
}
