package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
