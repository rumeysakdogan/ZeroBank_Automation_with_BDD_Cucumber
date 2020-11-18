package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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


    //Sherzat

    @FindBy (linkText = "Pay Bills")
    private WebElement payBillButton;

    public void clickpayBilllink (){
        payBillButton.click();
    }

    @FindBy (linkText = "Purchase Foreign Currency")
    private  WebElement purchaseForeignCurrency;
    public void clickpurchaseForeignCurrencylink (){
        purchaseForeignCurrency.click();
    }

    @FindBy (id="pc_currency")
    private WebElement currencyDropDown;

    public List<WebElement> getAllCurrencyDropDown(){

        Select select = new Select(currencyDropDown);
        return select.getOptions();
    }

    public void selectCurrenySelectOne(){
        Select select = new Select(currencyDropDown);
        select.selectByVisibleText("Select One");
    }

    public void selectCurreny(){
        Select select = new Select(currencyDropDown);
        select.selectByVisibleText("Canada (dollar)");
    }


    @FindBy (id="pc_amount")
    private WebElement amount;

    public void fillingAmount(){
        amount.sendKeys("500");
    }

     @FindBy (id="pc_inDollars_true")
    private WebElement usDollarRadioButton;

    public void clickusDollarRadioButton(){
        usDollarRadioButton.click();
    }

    @FindBy (id="purchase_cash")
    private WebElement purchaseButton;

    public void clickPurchaseButton(){
        purchaseButton.click();
    }

    @FindBy(id="pc_calculate_costs")
    private  WebElement caculateCostsButton;

    public void clickCaculateCostsButton(){
        caculateCostsButton.click();
    }
}
