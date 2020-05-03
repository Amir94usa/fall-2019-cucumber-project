@wip
Feature: Books table

  Scenario: Verify search results
    Given I am on the login page
    And I login to application as a student
    And I go to "Books" page
    When I search for "The Goldfinch"
    Then search table should contain results matching The Goldfinch


  Scenario: Verify book information
    Given I am on the login page
    And I login to application as a librarian
    And I go to "Books" page
    When I edit book The kite runner
    Then I verify book information:
      | name            | author          | year |
      | The kite runner | Khaled Hosseini | 2003 |