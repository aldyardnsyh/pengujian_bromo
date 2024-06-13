Feature: User login
  As a user, I want to log into the system so that I can access my dashboard

  Scenario: User login with valid credential
    Given the user is on the login page
    When the user enters a valid username and password
    And the user clicks the login button
    Then the user should be redirected to the main dashboard

  Scenario: User login with invalid credential
    Given the user is on the login page
    When the user enters an invalid username or password
    And the user clicks the login button
    Then the user should see a pop-up message "invalid credential"
