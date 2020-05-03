@smoke
Feature: Add new users dialogs

  Scenario: PlaceHolder tests
    Given I am on the login page
    And I login using following credentials:
      | email    | librarian21@library |
      | password | aZ849tSZ            |
    And I click on the "Users" link
    When I click on Add Users
    And dialog fields must have matching placeholder:
      | full name | Full Name |
      | email     | Email     |
      | password  | Password  |
      | address   |           |

  Scenario: Verify user information
    Given I am on the login page
    And I login using following credentials:
      | email    | librarian21@library |
      | password | aZ849tSZ            |
    And I click on the "Users" link
    When I search for "486"
    Then table should contain this data
      | User Id   | 486                             |
      | Full Name | Asuncion Pfeffer                |

      | Email     | Oralia Daugherty234@library.com |