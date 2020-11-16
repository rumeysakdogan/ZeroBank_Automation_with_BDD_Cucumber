package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AccountSummaryPage extends BasePage{

    @FindBy(xpath = "//h2")
    private List<WebElement> accountTypeHeaders;

    @FindBy(xpath = "(//table)[3]//th")
    private List<WebElement> creditAccountsHeaders;

    @FindBy(linkText = "Savings")
    private WebElement savingsLink;

    public List<WebElement> getAccountTypeHeaders(){
        return accountTypeHeaders;
    }

     public List<WebElement> getCreditAccountsHeaders(){
        return creditAccountsHeaders;
   }

   public void clickOnAccountLink(String link){

       WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        String linkXpath = "//td/a[.='"+ link +"']";

        WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkXpath)));
        linkElement.click();

   }
}
