Feature: Admin User Creation
     
  Scenario: Creating a new admin user
    Given The admin launches the Chrome browser
    And The admin enters the URL as "https://parklens-admin.tech-active.com/auth"
    And The admin enters valid email as "devops@active.agency" and password as "Devops@12345"
    And Clicks the login button    
    Then The admin should be redirected to the dashboard page
    When Clicks the setting side menu
    And Clicks the admin users header tab
    And Clicks the new button
    Then Verify i navigate to the add admin user page
    When Fill all the required user information:
    
    #When Enter the name as <Name> and mobile number as <Mobile>  and email as <Email> password as <Password> and retypepassword as <Retype Password>
   #| Name            | Mobile      | Email                 | Password  | RetypePassword |
   #| Admin-Anil      | 8956231470  | admin1@active.agency  | Admin123@ | Admin123@       |
   #| Admin-Anil      | 8956231470  | admin2@active.agency  | Admin123@ | Admin123@       |
   #| Admin-Anil      | 8956231470  | admin3@active.agency  | Admin123@ | Admin123@       |
    And Clicks the save button
    And Clicks the ok button in the confirmation popup
    Then The new admin user should be successfully created
    And The admin should be redirected to admin user details page
    When Clicks the profile icon
    Then Verify that the profile logo should be present 
    When Clicks the logout link
    Then Make sure the page should be redirected into the signin page
    And Close the chrome browser

    
    
      