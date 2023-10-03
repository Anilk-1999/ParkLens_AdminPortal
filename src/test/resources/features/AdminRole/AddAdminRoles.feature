Feature: Admin role creation

  Scenario: Creating a new admin role
    Given The admin launches the Chrome browser
    And The admin enters the URL as "https://parklens-admin.tech-active.com/auth"
    And The admin enters valid email as "devops@active.agency" and password as "Devops@12345"
    And Clicks the login button    
    Then The admin should be redirected to the dashboard page
    When Clicks the setting side menu
    And Clicks the admin roles header tab
    Then Make sure that the admin roles information page should appears
    And Clicks the new button
    Then Verify i should navigate to the add admin roles page
    When Enters the permission title
    And Select all the permission
    And Clicks the save button
    And Clicks the ok button in the confirmation popup
    Then The new admin role should be successfully created with confirmation message
    And The admin should be redirected to admin role details page
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser