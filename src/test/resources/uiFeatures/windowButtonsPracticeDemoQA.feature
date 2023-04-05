Feature: Verify the window buttons are working as expected
@windowButtonsPractice
  Scenario: Verify new window button feature
    Given user navigates to demoQA browser "browser-windows"page
    Then user sees the title of page as "DEMOQA"
    And user click on New Window button
    Then user switch to newly opened window
    And user see the url of page having "sample"
    Then user is able to close the new window
    And user switch to original window
    Then user see the title of page as "DEMOQA"


#  note: url is https://demoqa.com/browser-windows