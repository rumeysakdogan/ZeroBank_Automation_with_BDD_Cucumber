Feature: Login feature
Background:
  Given user is on a landing "page_url"

  @Login
  Scenario: Login(happy path)
    When user login with "username" and "password"
    Then user should see home page

  @Login
  Scenario Outline: Login(negative)
    When user login with "<username>" and "<password>"
    Then user should see error "Login and/or password are wrong."
    Examples: Wrong credentials
      | username       | password       |
      |                | password       |
      | username       |                |
      | wrong username | password       |
      | username       | wrong password |
