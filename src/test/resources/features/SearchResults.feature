@regression
Feature: Search functionality on the users page

  Background:
    Given I am on the login page
    And I login as a librarian user
    And I click on the "Users" link

  Scenario: Search accuracy

    When I search for "test"
    Then table should contain row with "test"


    Scenario: Table columns name
      Then table should have following columns names:
        | Actions   |
        | User ID   |
        | Full Name |
        | Email     |
        | Group     |
        | Status    |