@logout
Feature: As a user, I want to be able to create
  a new task with a title and description, so that I can keep track of my tasks effectively.

  Background: user is Logged in
    Given user is already logged in
    And Open Task List

  @PET-9
  Scenario: The user should be able to enter a title for the task
    When Locate the "Title" field on the form
    And Enter a valid title for the task in the "Title" field
    Then Save or submit the task.

  @PET-10
  Scenario: The user should be able to enter a description for the task
    When Locate the "Description" field on the form
    Then Enter a valid title for the task in the "Description" field

  @PET-11
  Scenario: After creating the task, it should be visible in the task list
    When Enter a valid title and description for the task
    And Save or submit the task
    Then Navigate to the task list or dashboard where tasks are displayed
