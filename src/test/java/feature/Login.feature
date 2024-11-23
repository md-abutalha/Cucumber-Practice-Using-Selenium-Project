Feature: Login

  Background:
    Given User should be on the login screen

  @login @sanity
  Scenario: User should be able to login with valid credentials
    When User enters a valid username and password
    And User clicks on the login button
    Then User should see the logout button
    And User should navigate to the inventory page
    But User should not be on the login page

  @login @invalid_login
  Scenario: User should not be able to login with invalid password
    When User enter valid "nalop30291@chysir.com" on the user name field
    And User enter "nalop30291@chysi" on the password field
    And User clicks on the login button
    Then User should see "Your email or password is incorrect!" error message

  @login @invalid_login
  Scenario: User should not be able to login with an invalid username
    When User enter "nalop30291@chysir.com1" on the username filed
    And User clicks on the login button
    Then User should see "Your email or password is incorrect!" validation message

  @login @invalid_login
  Scenario: User should not be able to login without username
    When  User enter "nalop30291@chysi" on the password field
    And User clicks on the login button
    Then User should see "Please fill out this field." validation message for username

  @login @invalid_login
  Scenario: User should not be able to login without password
    When User enter "shobuj@yopmail.com" on the username filed
    And User clicks on the login button
    Then User should see "Please fill out this field." validation message for password

  @login
  Scenario Outline: User should not be able to login with invalid credentials
    When User enter <username> on the username filed
    And User enter <password> on the password field
    And User clicks on the login button
    Then User should see <error_msg> error message
    Then User should see <validation_msg_username> validation message for username
    And  User should see <validation_msg_password> validation message for password
    Examples:
      | username            | password           | error_msg                              | validation_msg_username      | validation_msg_password      |
      | "nalop30291@chysi1" | "nalop30291@chysi" | "Your email or password is incorrect!" | ""                           | ""                           |
      | "nalop30291@chysi"  | "shobu222"         | "Your email or password is incorrect!" | ""                           | ""                           |
      | ""                  | "nalop30291@chysi" | ""                                     | "Please fill in this field." | ""                           |
      | "nalop30291@chysi"  | ""                 | ""                                     | ""                           | "Please fill in this field." |
      | ""                  | ""                 | ""                                     | "Please fill in this field." | ""                           |
