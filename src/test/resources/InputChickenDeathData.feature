Feature: Input chicken death data
  As a user, I want to input death data of the chicken so that I can keep track of the number of dead chickens

  Scenario: Input daily death
    Given the user is on the main dashboard
    When the user clicks the input death section
    And the user enters the number of dead chickens and the time the user checked the chicken coop
    And the user clicks the "report" button
    Then the system should confirm the data accuracy and update the total chicken count
    And the system should save the data to the database
