Feature: Login
  Background:
    Given the user is on the login page

  Scenario: User login with valid credential (owner)
    When the user enters "whyaziz" and "kkny5056"
    And the user clicks the login button
    Then the user should be redirected to the main dashboard

  Scenario: User login with valid credential (anak-kandang)
    When the user enters "yudacst" and "password"
    And the user clicks the login button
    Then the user should be redirected to the main dashboard

  Scenario: User login with invalid credential (anak-kandang)
    When the user enters "yudaaaa" and "password"
    And the user clicks the login button
    Then the user should be redirected to the main dashboard