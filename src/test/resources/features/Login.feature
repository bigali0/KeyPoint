Feature: Saucedemo login
  User Story: As a different type of user
  I should be able to login and dashboard should be displayed.

  Background: user is on login page
    Given user is on login page


  Scenario: Login as a user
   When the user logs in using username information
   And user clicks login button
  Then user should see homepage


  Scenario: Login as a problem_user
    When the user logs in using username2 information
    And user clicks login button
    Then user should see homepage

  Scenario: Login as a performance_glitch_user
   When the user logs in using username3 information
   And user clicks login button
    Then user should see homepage

  Scenario: Login as a locked_out_user_user
    When the user logs in using username1 information
    And user clicks login button
    Then user should see the error message



  @diffUser   ## : Login testing different user with Scenario Outline
  Scenario Outline: As a user, I should be able to login with different users using their user name and
  passwords. When I login, I should be able to see title .
   When User enters userType "<userType>"
    And  User enters password "<password>"
    And user clicks login button
    Then user should see homepage
    Examples:
     |userType|password|
     |standard_user|secret_sauce|
     |problem_user|secret_sauce |
     |performance_glitch_user|secret_sauce |
