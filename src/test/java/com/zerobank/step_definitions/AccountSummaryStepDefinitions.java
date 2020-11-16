package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefinitions {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("Account summary page should have following account types:")
    public void account_summary_page_should_have_following_account_types(List<String> expectedAccountTypes) {

        BrowserUtils.wait(1);
        List<String> actualAccountTypes = BrowserUtils.getElementsText(accountSummaryPage.getAccountTypeHeaders());

        Assert.assertEquals(actualAccountTypes, expectedAccountTypes);

    }

    @Then("Credit Accounts table must have following columns:")
    public void credit_accounts_table_must_have_following_columns(List<String> expectedColumns) {

        BrowserUtils.wait(1);
        List<String> actualAccountTypes = BrowserUtils.getElementsText(accountSummaryPage.getCreditAccountsHeaders());

        Assert.assertEquals(actualAccountTypes, expectedColumns);
    }
}
