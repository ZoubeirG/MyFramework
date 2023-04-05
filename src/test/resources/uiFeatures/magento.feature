@HoverPractice
Feature: User should be able to hover over tabs and click results

@HoverPracticeGearTab
  Scenario: As a user i can hover over Gear section and get to Fitness Equipment page
    Given I'm on magento homepage
    Then i hover over gear tab
    And i click on Fitness Equipment
    Then i ma navigated to Fitness Equipment page
