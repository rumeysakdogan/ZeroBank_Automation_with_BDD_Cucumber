package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OnlineStatementsPage extends BasePage {
    public OnlineStatementsPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
//    @FindBy(xpath = "//a[@href='#os_2010']")
//    private WebElement statementYearLink;

    public void selectingStatements(Integer year){
        WebElement statementYearLink=Driver.getDriver().findElement(By.xpath("//a[@href='#os_"+year+"']"));
        statementYearLink.click();
    }
    public int numberOfStatements(Integer year){
        List<WebElement> statements = Driver.getDriver().findElements(By.xpath("//div[@id='os_" + year + "']//a"));
        return statements.size();
    }




}
