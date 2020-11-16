package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void navigateTo(String tab) {
        WebElement mainPageTabs = Driver.getDriver().findElement(By.xpath("//a[text()=\"" + tab + "\"]"));
        mainPageTabs.click();
    }


}
