package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on a landing {string}")
    public void user_is_on_a_landing(String string) {
        loginPage.landingPage(string);
    }


    @When("user login with {string} and {string}")
    public void user_login_with_and(String username, String password) throws InterruptedException {

        loginPage.login(username, password);

    }

    @Then("user should see home page")
    public void user_should_see_home_page() {
        Assert.assertEquals("Wrong page!!!", ConfigurationReader.getProperty("page_title"), Driver.getDriver().getTitle());
    }


    @Then("user should see error {string}")
    public void userShouldSeeError(String massage) {
        Assert.assertEquals("Wrong massage", massage, loginPage.getErrorMessageText().trim());


    }


}
