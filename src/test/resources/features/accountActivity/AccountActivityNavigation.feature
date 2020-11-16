@accountActivityNavigation
Feature: Navigating to specific accounts in Accounts Activity

  Scenario: Savings account redirect
    Given the user is logged in
    When the user clicks on "Savings" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Savings" selected

  @wip
  Scenario Outline: <account> account redirect
    Given the user is logged in
    When the user clicks on "<account>" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "<account>" selected

    Examples: accounts in dropdown
      | account     |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |