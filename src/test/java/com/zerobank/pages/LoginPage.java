package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.event.KeyEvent;

public class LoginPage extends BasePage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user_login")
    private WebElement usernameField;
    @FindBy(id = "user_password")
    private WebElement passwordField;
    @FindBy(xpath = "//div[@class='alert alert-error']")
    private WebElement errorMessage;

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password, Keys.ENTER);
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public void landingPage(String url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(url));
    }

}
