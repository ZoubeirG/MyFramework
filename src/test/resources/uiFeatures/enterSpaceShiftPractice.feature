Feature: enter and confirm actions buttons

  @keyboardPractice
  Scenario Outline: As a User i am able to click enter, space and shift buttons
    Given i am one the "https://the-internet.herokuapp.com/key_presses" Practice page
    Then i navigate to the search box and click <desiredKey>
    Then i should see the confirmation message matching the <desiredKey> text
    Examples:
      | desiredKey |
      | ENTER      |
      | SHIFT      |
      | SPACE      |

