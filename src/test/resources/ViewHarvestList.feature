Feature: View list of panen
  As an owner, I want to view the list of panen so that I can track the harvest results

  Scenario: View list of panen
    Given the user is on the main dashboard as an owner
    When the user clicks the Panen section
    Then the user should be redirected to the Panen page
