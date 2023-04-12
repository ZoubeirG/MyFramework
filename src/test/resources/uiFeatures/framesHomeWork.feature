@regression
Feature: Frame page verification
@nestedFramesHomeWork
  Scenario: Verify available texts in a page
    Given i am one the the internet heroku app Practice page
    Then i click on the Frames tab
    And user clicks on nested Frames tab
    And user should be able to see below texts
      | text   |
      | LEFT   |
      | RIGHT  |
      | MIDDLE |
      | BOTTOM |