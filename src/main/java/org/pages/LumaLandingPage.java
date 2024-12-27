package org.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.untils.Waiters;

public class LumaLandingPage {

    @FindBy(id = "aswift_1")
    public WebElement adFrame;

    @FindBy(id = "mys-wrapper")
    public WebElement mySwapper;

    @FindBy(id = "ui-id-6")
    public WebElement dropDownGear;

    @FindBy(id = "ui-id-27")
    public WebElement dropDownGearWatches;

    @FindBy(id = "ui-id-2")
    public WebElement topLine;

    @FindBy(xpath = "//ul[@id='ui-id-2']/li[@role='presentation']")
    public List<WebElement> listOfTopLineElements;

    public LumaLandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void findAndSwitchToIFrame(WebDriver webDriver) {
        webDriver.switchTo().frame(adFrame);
    }

    public LumaWatchesPage clickOnDropDownGearWatches(WebDriver webDriver, Actions actions, Waiters waiters) {
        waiters.waitUntilVisible(webDriver, dropDownGear, 10);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", dropDownGear);
        actions.moveToElement(dropDownGear).perform();
        dropDownGearWatches.click();

        return new LumaWatchesPage(webDriver);
    }

    public List<WebElement> getAllTopLineWebElements(Waiters waiters, WebDriver webDriver) {
        waiters.waitUntilVisible(webDriver, topLine, 10);
        return listOfTopLineElements;
    }

    public String getLink(WebDriver webDriver) {
        return webDriver.findElement(By.id("ui-id-3")).getAttribute("href");
    }

}
