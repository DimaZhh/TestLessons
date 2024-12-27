package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {

    @FindBy(xpath = "//*[@id='user-name']")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    WebElement errorText;

    public SauceLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String loginWithWrongCredentialsAndGetErrorText() {
        userName.sendKeys("standard_user_test-value");
        password.sendKeys("standard_password_test-value");

        if (loginButton.isDisplayed()) {
            loginButton.click();
        } else {
            throw new RuntimeException("Login button is not displayed");
        }

        return errorText.getText();
    }
}
