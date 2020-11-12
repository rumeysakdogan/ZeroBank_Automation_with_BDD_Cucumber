package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = "signin_button")
    private WebElement signInButton;

    public void clickOnSignInButton(){
        signInButton.click();
    }

}
