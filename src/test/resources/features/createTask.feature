
Feature: As a user, I want to be able to create
  a new task with a title and description, so that I can keep track of my tasks effectively.

  Background: user is Logged in
    Given user navigates to main page and already logged in
    And click Task List

  @PET-19
  Scenario: The task list should display all the tasks assigned to the user
    Then User should see all the tasks assigned

  @PET-20
  Scenario: Each task should be displayed with its title, description, and relevant details.
    When User opens any Task
    Then User see title, description, and relevant details

  @PET-21
  Scenario: The task list should be sortable based on different criteria (e.g., priority, due date, status).
    When User click sort and click name
    Then Tasks should be sorted by name a-z