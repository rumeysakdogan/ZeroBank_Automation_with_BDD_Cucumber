package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class PayBillStepDefinitions {

    AccountActivityPage accountActivityPage = new AccountActivityPage();


    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_purchase_foreign_currency_cash_tab() {

        accountActivityPage.clickPayBillLink();
        accountActivityPage.clickPurchaseForeignCurrencyLink();
        BrowserUtils.wait(2);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrency) {
        List<String> actualCurrency = new ArrayList<>();

        for (int i = 1; i < accountActivityPage.getAllCurrencyDropDown().size(); i++) {
            actualCurrency.add(accountActivityPage.getAllCurrencyDropDown().get(i).getText());
        }

        Assert.assertEquals(expectedCurrency, actualCurrency);
    }


    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

        accountActivityPage.selectCurrencySelectOne();
        accountActivityPage.fillingAmount();
        accountActivityPage.clickPurchaseButton();


    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {

        accountActivityPage.selectCurrency();
        accountActivityPage.clickCalculateCostsButton();

    }


    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        String actualMessage = accountActivityPage.alarmMessage();
        System.out.println(actualMessage);
        String expectedErrorMsg = "Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertTrue( actualMessage.contains(expectedErrorMsg));

    }


}


