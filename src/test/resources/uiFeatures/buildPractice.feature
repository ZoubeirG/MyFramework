@buildPractice
Feature: User should be able type item is search box then click search

  @searchBoxPracticeShift
  Scenario: As a user i should be able type item is search box then click search
    Given I'm on magento homepage
    Then locate, hover over and click the search box
    And write "jeans" with upper case letters using keys.SHIFT in the search box
    And Double click in the search box and perform and build
    Then click the search