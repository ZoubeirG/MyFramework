Feature: navigate to frame and input text

  @iFramesPractice
  Scenario: user navigates to frames page on site and enters tetx in frame
    Given i am one the the internet heroku app Practice page
    Then i click on the Frames tab
    Then i click on the iFrame tab
    Then i type "i am in the iFrame tab" in the text box
    Then i confirm the text in the filed is "i am in the iFrame tab"
