Feature: Realtime monitoring
  As a user, I want to monitor the condition of the cage in real-time so that I can ensure everything is fine

  Scenario: View real-time data
    Given the user is on the main dashboard
    When the user clicks the monitoring section
    Then the user should see real-time data of ammonia, temperature, and humidity levels

  Scenario: View humidity level real-time data
    Given the user is on the main dashboard
    When the user clicks the monitoring section
    Then the user should see real-time data of ammonia, temperature, and humidity levels
    When the user clicks the humidity level
    Then the user should see a real-time table of humidity level
