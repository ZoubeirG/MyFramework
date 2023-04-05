Feature: alert click

  @AlertClick
  Scenario: click on alert to close it
    Given i am on site
    Then i select the second click me tab
    Then i switch to the alert and confirm it.
