Feature: User adds and validates expense

@MealBAddExpense
  Scenario: Create Meal and Entertainment expense
    Given i am logged on to the Meal B Practice page
    And i click on Expenses tab
    Then i click on Add Expenses tab and select Meal & Entertainment for the drop down list
    Then i complete the Create Meal & Entertainment expense information
    When i click save button
    And my newly added expense is displayed on table


