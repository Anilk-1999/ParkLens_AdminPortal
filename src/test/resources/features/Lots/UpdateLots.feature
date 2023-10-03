Feature: Lot update

 Scenario: Updating lot information
    Given The admin launches the Chrome browser
    And The admin enters the URL as "https://parklens-admin.tech-active.com/auth"
    And The admin enters valid email as "devops@active.agency" and password as "Devops@12345"
    And Clicks the login button 
    Then The admin should be redirected to the dashboard page
    When Clicks the lots side menu
    Then Make sure that the lots information page should appears
    And Clicks the edit icon
    Then Verify i should navigate to the edit lot page
    When Change all the required lot informations:
    And Clicks the save button
    And Clicks the ok button in the confirmation popup
    Then The lot should successfully updated with confirmation message
    When Clicks the violation link
    #And Clicks on edit icon
    #And Enter the Exempted Duration
    #And Enter the flat fee
    #And Clicks the save button
    #And Clicks the ok button in the confirmation popup
    #Then The fees should successfully updated with confirmation message
    When Clicks the general link
    And Clicks the edit overlay link
    And Clicks the update button
    And Clicks the ok button in the confirmation popup
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser