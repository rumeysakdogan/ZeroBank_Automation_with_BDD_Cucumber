package com.zerobank.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "user_login")
    private WebElement usernameInputBox;

    @FindBy(id = "user_password")
    private WebElement passwordInputBox;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    private WebElement errorMessage;

    public void login(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password + Keys.ENTER);
    }

    public WebElement getErrorMessage(){
        return errorMessage;
    }
}
