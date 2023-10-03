Feature: Camera update

 Scenario: Updating camera information
    Given The admin launches the Chrome browser
    And The admin enters the URL as "https://parklens-admin.tech-active.com/auth"
    And The admin enters valid email as "devops@active.agency" and password as "Devops@12345"
    And Clicks the login button 
    Then The admin should be redirected to the dashboard page
    When Clicks the cameras side menu
    Then Make sure that the camera information page should appears
    And Clicks the edit icon
    Then Verify i should navigate to the edit camera page
    When Change all the required camera informations:
    And Clicks the save button
    And Clicks the ok button in the confirmation popup
    Then The camera should successfully updated with confirmation message
    And The admin should be redirected to camera details page
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser