package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

public class OnlineStatementsPage extends BasePage {
    public OnlineStatementsPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
//    @FindBy(xpath = "//a[@href='#os_2010']")
//    private WebElement statementYearLink;

    public void selectingStatements(Integer year) {
        WebElement statementYearLink = Driver.getDriver().findElement(By.xpath("//a[@href='#os_" + year + "']"));
        BrowserUtils.waitForClickability(statementYearLink,5);
        statementYearLink.click();
    }

    public int numberOfStatements(Integer year) {
        List<WebElement> statements = Driver.getDriver().findElements(By.xpath("//div[@id='os_" + year + "']//a"));
        return statements.size();
    }

    public void clickingOnStatement(String statementName) {
        WebElement statement = Driver.getDriver().findElement(By.linkText(statementName));
        BrowserUtils.waitForClickability(statement, 5);
        statement.click();
    }

    public String downloadedFileName() {
        String downloadPath = "C:\\Users\\vpisa\\Downloads";
        File dir = new File(downloadPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }
        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (files[i].lastModified() < lastModifiedFile.lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        String fileName=lastModifiedFile.getName();

        System.out.println("Downloaded file name: " + lastModifiedFile.getName());
        return fileName;
    }
    public void deleteStatement(){
        String downloadPath = "C:\\Users\\vpisa\\Downloads";
        File dir = new File(downloadPath);
        File[] files = dir.listFiles();
        assert files != null;
        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (files[i].lastModified() < lastModifiedFile.lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        lastModifiedFile.delete();
    }


}
