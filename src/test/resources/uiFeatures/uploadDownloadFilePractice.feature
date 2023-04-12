@regression
Feature: practice upload file automation

  @uploadFilePractice
  Scenario: user uploads a document to a site
    Given  user navigates to to "https://the-internet.herokuapp.com/upload" practice page
    Then  user clicks the choose file tab and sends the location of the file
    Then user clicks the upload tab
    Then user should see the file uploaded message to on the confirmation page

  @downloadFilePractice
  Scenario: user downloads a document from a site
    Given  user navigates to to "https://the-internet.herokuapp.com/download" practice page
    Then  user clicks the file to download

