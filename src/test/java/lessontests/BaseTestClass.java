package lessontests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.conf.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.untils.Waiters;

public class BaseTestClass {

    private Waiters waiters = new Waiters();
    private ReadPropertyFile readPropertyFile = new ReadPropertyFile();
    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setUp() {
        WebDriverManager driverManager = WebDriverManager.getInstance("CHROME").watch();
        driverManager.create();
        driver = driverManager.getWebDriver();
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public Waiters getWaiters() {
        return waiters;
    }

    public ReadPropertyFile getReadPropertyFile() {
        return readPropertyFile;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Actions getActions() {
        return actions;
    }
}
