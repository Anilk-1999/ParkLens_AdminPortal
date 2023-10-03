Feature: Camera deletion

 Scenario: Deleting camera information
    Given The admin launches the Chrome browser
    And The admin enters the URL as "https://parklens-admin.tech-active.com/auth"
    And The admin enters valid email as "devops@active.agency" and password as "Devops@12345"
    And Clicks the login button 
    Then The admin should be redirected to the dashboard page
    When Clicks the cameras side menu
    Then Make sure that the camera information page should appears
    When Get the first id in the table
    Then Clicks the edit icon
    And Verify i should navigate to the edit camera page
    When Clicks the delete button
    And Clicks the ok button in the confirmation popup
    Then The camera should successfully deleted with confirmation message
    And Verify that the deleted records should not be visible in the table
    And The admin should be redirected to camera details page
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser