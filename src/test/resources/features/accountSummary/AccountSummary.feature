@accountSummary
Feature: Account Summary

  Background: common step
    Given user on Zero bank login page
    When user logs in with "username" and "password"

  @account_types
  Scenario: Account Types Verification
    Then Account summary page should have following account types:
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |



  @creditAccount_columns
  Scenario: Credit Accounts Table' Columns Verification
    Then Credit Accounts table must have following columns:
      | Account     |
      | Credit Card |
      | Balance     |