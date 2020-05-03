
Feature: Page navigation links
 Background:
   Given I am on the login page
   And I login as a librarian user
  @db
  Scenario: Go to users page
    When I click on the "Users" link
    Then "Users" page should be displayed

    Scenario: Go to books page
      When I click on the "Books" link
      Then "Books" page should be displayed


    Scenario: go to dashboard page
      And I click on the "Books" link
      When I click on the "Dashboard" link
      Then "Dashboard" page should be displayed

