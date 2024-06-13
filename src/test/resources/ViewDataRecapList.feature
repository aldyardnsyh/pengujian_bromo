Feature: View list of rekap data
  As an owner, I want to view the list of rekap data from the cage so that I can review historical records

  Scenario: View list of Data Recap
    Given the user is on the main dashboard as an owner
    When the user clicks the Rekap Data section
    Then the user should be redirected to the Rekap Data page
