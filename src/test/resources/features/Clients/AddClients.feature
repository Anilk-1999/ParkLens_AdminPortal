Feature: New client creation

 Scenario: Creating a new client
    Given The admin launches the Chrome browser
    And The admin enters the URL as "https://parklens-admin.tech-active.com/auth"
    And The admin enters valid email as "devops@active.agency" and password as "Devops@12345"
    And Clicks the login button 
    Then The admin should be redirected to the dashboard page
    When Clicks the client side menu
    Then Make sure that the client information page should appears
    And Clicks the new button
    Then Verify i should navigate to the add client page
    When Fill all the required client informations:
    And Clicks the save button
    And Clicks the ok button in the confirmation popup
    Then The new client should be successfully created with confirmation message
    And The admin should be redirected to client details page
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser