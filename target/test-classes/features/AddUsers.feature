 @show_records @smoke  @lib-7031
Feature: Add Users window

  Background:
    Given I access Users page as a librarian
    And I click on Add User

  Scenario: Add users window default dates
    Then start date should be today's date
    And end date should be one month from today

  Scenario: Add users close button
    And I enter new user information with random email
    When I click the Close link
    Then the users table should not contain user with that email

  Scenario: Save new user

    When I save new user information with random email
    When the users table must contain the correct user information

  Scenario: Duplicate email test

    And I save new user information with random email
    And I click on Add User
    When I try to add new with the same email
    Then Add User dialog should still be open