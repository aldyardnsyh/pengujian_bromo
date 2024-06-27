Feature: View list of kandang
  As an owner, I want to view the list of kandang so that I can manage them
  Background:
    Given the user is on the main dashboard as an owner

  Scenario: View list of kandang
    When the user clicks the Kandang section
    Then the user should be redirected to the Kandang page
