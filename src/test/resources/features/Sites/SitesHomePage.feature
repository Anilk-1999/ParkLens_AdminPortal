Feature: Sites Home Page

  Background:
    Given The admin launches the Chrome browser
    And The admin enters the URL as "https://parklens-admin.tech-active.com/auth"
    And The admin enters valid email as "devops@active.agency" and password as "Devops@12345"
    And Clicks the login button    
    Then The admin should be redirected to the dashboard page
    When Clicks the sites side menu
   
  Scenario: Search site by name.
    And Enter the name into search textfield
    And Click on enter
    Then Make sure that the searched name should displayed in the table
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser
    
  Scenario: Search site by id.
    And Enter the id into search textfield
    And Click on enter
    Then Make sure that the searched id should displayed in the table
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser 

  
  Scenario: filter the active status.
    When Click on status filter dropdown
    And Select a active status
    Then Ensure that only the active records should displayed on the table
    When Click on reset button
    Then Verify that all the records should displayed on the table
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser
    
    
  Scenario: filter the inactive status.
    When Click on status filter dropdown
    And Select a inactive status
    Then Ensure that only the inactive records should displayed on the table
    When Click on reset button
    Then Verify that all the records should displayed on the table
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser
     
  Scenario: filter all status.
    When Click on status filter dropdown
    And Select a all status
    Then Verify that all the records should displayed on the table
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser   
    
  Scenario: The per-page functionality is working correctly for forty records. 
    When Select a forty record
    Then Verify that the forty records should displayed on the table
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser
     
  Scenario: The per-page functionality is working correctly for thirty records. 
    When Select a thirty records
    Then Verify that the thirty records should displayed on the table
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser
    
  Scenario: The per-page functionality is working correctly for twenty records. 
    When Select a twenty records
    Then Verify that the twenty records should displayed on the table
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser 
    
  Scenario: The sorting functionality is working correctly for descending order. 
    When Click on descending icon
    Then Verify that all the records should displayed on descending order
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser  
    
  Scenario: The sorting functionality is working correctly for ascending order. 
    When Click on ascending icon
    Then Verify that all the records should displayed on ascending order
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser  
      
    
    