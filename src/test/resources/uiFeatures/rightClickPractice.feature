@regression
Feature: right click and select alert

  @rightClickPractice
  Scenario: user navigates to practice site then write clicks using Action Class
    Given user is on the practice webpage
    Then user clicks the right click me tab
    And user clicks Copy tab
    Then user switch and get text from alert
    And user clicks ok to alert


