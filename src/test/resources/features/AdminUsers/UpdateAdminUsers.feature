Feature: Admin users update

 Scenario: Updating admin users information
    Given The admin launches the Chrome browser
    And The admin enters the URL as "https://parklens-admin.tech-active.com/auth"
    And The admin enters valid email as "devops@active.agency" and password as "Devops@12345"
    And Clicks the login button 
    Then The admin should be redirected to the dashboard page
    When Clicks the setting side menu
    And Clicks the admin users header tab
    Then Make sure that the admin users information page should appears
    And Clicks the edit icon
    Then Verify i should navigate to the edit admin users page
    When Change all the required admin user informations:
    And Clicks the save button
    And Clicks the ok button in the confirmation popup
    Then The admin users should successfully updated with confirmation message
    And The admin should be redirected to admin user details page
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser