package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityPage extends BasePage{

    @FindBy(id = "aa_accountId")
    private WebElement accountDropDown;

    public String getSelectedOptionFromAccountDropDown(){
        Select select = new Select(accountDropDown);
        return select.getFirstSelectedOption().getText();
    }

    public String getAcountActivityTitle(){
        return Driver.getDriver().getTitle();
    }
}
