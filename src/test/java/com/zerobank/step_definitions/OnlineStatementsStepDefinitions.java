package com.zerobank.step_definitions;

import com.zerobank.pages.OnlineStatementsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OnlineStatementsStepDefinitions {
    OnlineStatementsPage onlineStatementsPage = new OnlineStatementsPage();

    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tab) {
        onlineStatementsPage.navigateTo(tab);

    }

    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_recent_statements_year(Integer int1) {
        onlineStatementsPage.selectingStatements(int1);

    }
    @Then("{int} statements should be displayed for that {int}")
    public void statements_should_be_displayed_for_that(Integer count, Integer year) {
        Integer actual = onlineStatementsPage.numberOfStatements(year);
        Assert.assertEquals("Wrong number of statements", count, actual);
    }

    @Given("the user accesses the Statements & Documents tab")
    public void theUserAccessesTheStatementsDocumentsTab() {
    }

    @When("the user clicks on statement {string}")
    public void theUserClicksOnStatement(String arg0) {
    }

    @Then("the downloaded file name should contain {string}")
    public void theDownloadedFileNameShouldContain(String arg0) {
    }


    @And("the file type should be pdf")
    public void theFileTypeShouldBePdf() {
    }
}
