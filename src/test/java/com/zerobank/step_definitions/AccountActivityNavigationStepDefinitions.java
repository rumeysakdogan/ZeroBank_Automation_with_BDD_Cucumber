package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigationStepDefinitions {

    LoginPage loginPage = new LoginPage();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("page_url"));
        loginPage.login("username","password");
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_account_summary_page(String link) {
       accountSummaryPage.clickOnAccountLink(link);
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedInTitle) {
        Assert.assertTrue(accountActivityPage.getAccountActivityTitle().contains(expectedInTitle));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expected) {
        Assert.assertEquals(accountActivityPage.getSelectedOptionFromAccountDropDown(),expected);
    }
}
