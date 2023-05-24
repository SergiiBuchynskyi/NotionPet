@CreateTask
Feature: As a user, I want to be able to create
  a new task with a title and description, so that I can keep track of my tasks effectively.

  Background: user is Logged in
    Given user navigates to main page and already logged in
    And click Task List

  @PET-39
  Scenario: Each task should contain title and description
    When User click New button and create task name "Car"
    Then User see title and description is displayed

  @PET-19
  Scenario: The task list should display all the tasks assigned to the user
    Then User should see all the tasks assigned

  @PET-20
  Scenario: Each task should be displayed with its title, description.
    When User opens any Task
    Then User see title, description, and relevant details