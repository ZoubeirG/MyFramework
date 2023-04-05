Feature: toolTip message present

  @toolTipMessage
  Scenario: As i user i should be able to see the age message
    Given i am on the jquery site
    And i hover over the age input box
    Then i should be able to see the tootTip box