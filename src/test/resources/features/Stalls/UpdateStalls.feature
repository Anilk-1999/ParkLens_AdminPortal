Feature: Stalls update

 Scenario: Updating stalls information
    Given The admin launches the Chrome browser
    And The admin enters the URL as "https://parklens-admin.tech-active.com/auth"
    And The admin enters valid email as "devops@active.agency" and password as "Devops@12345"
    And Clicks the login button 
    Then The admin should be redirected to the dashboard page
    When Clicks the lots side menu
    Then Make sure that the lots information page should appears
    When Click on the stalls icon
    Then Verify that the stalls map page should be dispalyed
    When Click On list icon
    Then Verify that the page should redirected to stalls details page
    When Clicks the edit icon
    Then Make sure that the edit stalls page should be displayed
    When Select the camera
    And select the status
    And Set Attribute and attribute value
    And Click on the update button
    And Clicks the ok button in the confirmation popup
    Then Verify that the stalls should be updated with the confirmation message
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser