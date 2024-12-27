package org.ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaWatchesPage {

    @FindBy(className = "items")
    public WebElement itemsElement;

    @FindBy(xpath = "//*[@data-ui-id='page-title-wrapper']")
    public WebElement pageTitleWrapperElement;

    public LumaWatchesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getTitleWrapperText(WebDriver webDriver) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", itemsElement);
        return pageTitleWrapperElement.getText();
    }

}
