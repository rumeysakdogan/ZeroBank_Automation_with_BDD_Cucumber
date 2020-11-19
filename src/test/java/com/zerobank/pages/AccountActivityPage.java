package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    private WebElement accountDropDown;

    public String getSelectedOptionFromAccountDropDown() {
        Select select = new Select(accountDropDown);
        return select.getFirstSelectedOption().getText();
    }

    public String getAccountActivityTitle() {
        return Driver.getDriver().getTitle();
    }


    //Sherzat

    @FindBy(linkText = "Pay Bills")
    private WebElement payBillButton;

    public void clickPayBillLink() {
        BrowserUtils.waitForClickability(payBillButton, 5);
        payBillButton.click();
    }

    @FindBy(linkText = "Purchase Foreign Currency")
    private WebElement purchaseForeignCurrency;

    public void clickPurchaseForeignCurrencyLink() {
        purchaseForeignCurrency.click();
    }

    @FindBy(id = "pc_currency")
    private WebElement currencyDropDown;

    public List<WebElement> getAllCurrencyDropDown() {

        Select select = new Select(currencyDropDown);
        return select.getOptions();
    }

    public void selectCurrencySelectOne() {
        Select select = new Select(currencyDropDown);
        select.selectByVisibleText("Select One");
    }

    public void selectCurrency() {
        Select select = new Select(currencyDropDown);
        select.selectByVisibleText("Canada (dollar)");
    }


    @FindBy(id = "pc_amount")
    private WebElement amount;

    public void fillingAmount() {
        amount.sendKeys("500");
    }

    @FindBy(id = "pc_inDollars_true")
    private WebElement usDollarRadioButton;

    public void clicksDollarRadioButton() {
        BrowserUtils.waitForClickability(usDollarRadioButton, 5);
        usDollarRadioButton.click();
    }

    @FindBy(id = "purchase_cash")
    private WebElement purchaseButton;

    public void clickPurchaseButton() {
        BrowserUtils.waitForClickability(purchaseButton, 5);
        purchaseButton.click();
    }

    @FindBy(id = "pc_calculate_costs")
    private WebElement calculateCostsButton;

    public void clickCalculateCostsButton() {
        BrowserUtils.waitForClickability(calculateCostsButton, 5);
        calculateCostsButton.click();
    }

    public String alarmMessage() {


        try {
            Alert alert = Driver.getDriver().switchTo().alert();
//        String errorMessage = alert.getText();
//        System.out.println(errorMessage);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "errorMessage";

    }


}
