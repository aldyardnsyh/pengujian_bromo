Feature: Input daily data
  As a user, I want to input death data of the chicken so that I can keep track of the number of dead chickens
  Background:
    Given the user is on the main dashboard anak kandang

  Scenario: Input daily death
    When the user clicks the input data section
    And the user enters the data
    And the user clicks the "report" button
    Then the system should confirm the data accuracy and update the total chicken count
