Feature: Admin Login
  As a Admin
  I want to log in to the application
  So that I can access my account

  Background:
    Given The admin launches the Chrome browser
    And The admin enters the URL as "https://parklens-admin.tech-active.com/auth"

  Scenario: Successful login into parklens admin portal
    When The admin enters valid email as "devops@active.agency" and password as "Devops@12345"
    And Clicks the login button
    Then The admin should be redirected to the dashboard page
    When Clicks the profile icon
    Then Verify that the profile logo should be present
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser

  Scenario: Login with invalid credentials
    When The admin enters invalid email as "devops@gmail.com" and password as "Devops@12"
    And Clicks the login button
    Then An error message should be displayed
    And Close the chrome browser

  Scenario: Login without email
    When The admin leaves the email field empty
    And Enters a valid password as "Devops@12345"
    And Clicks the login button
    Then An error message should be displayed
    And Close the chrome browser

  Scenario: Login without password
    When Enter a valid email as "devops@active.agency"
    And The admin leaves the password field empty
    And Clicks the login button
    Then An error message should be displayed
    And Close the chrome browser

  Scenario: Login with empty credentials
    When The admin leaves the email field empty
    And The admin leaves the password field empty
    And Clicks the login button
    Then An error message should be displayed
    And Close the chrome browser
