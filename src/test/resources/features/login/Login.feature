@login
Feature: Login

  As a user, I should be able to login to zero bank successfully.

  Background: common steps
    Given user on Zero bank home page
    When user clicks on signin button


  Scenario: Login with valid credentials
    And user logs in with "username" and "password"
    Then Account summary page should be displayed


  @negative_login
  Scenario Outline: Login with invalid credentials, username: <username>  password: <password>
    When user logs in with invalid "<username>" or "<password>"
    Then error message "Login and/or password are wrong." should be displayed

    Examples:
      | username | password |
      | wrong    | password |
      | username | wrong    |
      |          | password |
      | username |          |