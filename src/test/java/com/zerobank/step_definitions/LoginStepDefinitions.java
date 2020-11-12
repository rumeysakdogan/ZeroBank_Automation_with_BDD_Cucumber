package com.zerobank.step_definitions;

import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("user on Zero bank home page")
    public void user_on_zero_bank_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user clicks on signin button")
    public void user_clicks_on_signin_button() {
        homePage.clickOnSignInButton();
    }

    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        String expectedInTitle = "Account Summary";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    @When("user logs in with invalid {string} or {string}")
    public void user_logs_in_with_invalid_or(String username, String password) {
        loginPage.login(username, password);
    }


    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage) {
        String actual = loginPage.getErrorMessage().getText();
        Assert.assertEquals(actual,expectedMessage);
    }
}
