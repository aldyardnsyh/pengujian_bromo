Feature: Input data panen
  As a user, I want to input data panen so that I can keep track of the harvest results

  Scenario: Input harvest data on the harvest day
    Given the user is on the main dashboard
    When the user clicks the input data panen section
    And the user enters the number of chickens and the total weight
    And the user clicks the "report" button
    Then the system should confirm the data accuracy
    And the system should save the data to the database
