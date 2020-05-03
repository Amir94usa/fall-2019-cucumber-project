@regression
Feature: Show records functionality

  Background:
    Given I am on the login page
    And I login as a librarian user
    @wi
    Scenario: verify default value
      When I click on the "Users" link
      Then show records default value should be 10
      And show records should have following options:
        |5  |
        |10 |
        |15 |
        |50 |
        |100|
        |200|
        |500|

        Scenario: Change number of scenarios
          And I click on the "users" link
          When I select Show 50 records'
          Then the users table must display 50 records



      Scenario Outline:Show records for<count> options
        And I click on the "Users" link
        When I select Show <count> records
        Then show records default value should be <count>
        And the users table must display <count> records

        Examples:
        |count|
        |5  |
        |10 |
        |15 |
        |50 |
        |100|