@DragTask
Feature: As a user, I want to be able drug task to different sections

  Background: user is Logged in
    Given user navigates to main page and already logged in
    And click Task List

  Scenario:user has to be able to drag task to different section
    When User click New button and create task name "Groceries"
    And hold and drag Task to another section
    Then Task status is changed