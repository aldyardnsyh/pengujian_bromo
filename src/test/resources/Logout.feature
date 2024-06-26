Feature: Logout
  As a user, I want to logout from the system so that I can secure my account
  Background:
    Given the user is on the main dashboard

  Scenario: User logout
    When the user clicks the Profile Dropdown
    And the user clicks the logout button
    Then the user clicks the yes button to confirm
    And the user should be redirected to the landing page
