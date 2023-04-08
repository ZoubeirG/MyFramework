Feature: use js executor to click tab

  Background:
    Given I'm on logged in to OrangeHRM as admin
      @jsExecutorPractice
      Scenario: I click on EmployeeList using JS Executor
        And i click on the PIM tab
        And i click EmployeeList using JS Executor

