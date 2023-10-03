Feature: Attribute update

 Scenario: Updating attribute information
    Given The admin launches the Chrome browser
    And The admin enters the URL as "https://parklens-admin.tech-active.com/auth"
    And The admin enters valid email as "devops@active.agency" and password as "Devops@12345"
    And Clicks the login button
    Then The admin should be redirected to the dashboard page
    When Clicks the setting side menu
    Then Make sure that the attribute information page should appears
    And Clicks the edit icon
    Then Verify i should navigate to the edit attribute page
    When Change all the required attribute informations:
    And Clicks the save button
    And Clicks the ok button in the confirmation popup
    Then The attribute should successfully updated with confirmation message
    And The admin should be redirected to attribute details page
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser