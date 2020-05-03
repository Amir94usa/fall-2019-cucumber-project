
@Smoke @lib-100 @login
Feature: Login
  As a user, I should be able to login to the application
@librarian @staff
  Scenario: Login as an librarian
    Given I am on the login page
    When I login as a librarian user
    Then dashboard should be displayed
@student
  Scenario: Login as an student
    Given I am on the login page
    When I login as a student
    Then dashboard should be displayed
  @admin @staff
  Scenario: Login as an admin
    Given I am on the login page
    When I login as a admin
    Then dashboard should be displayed