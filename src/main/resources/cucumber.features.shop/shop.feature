Feature: Filling addresses fields
  As a user
  I want to be able to add a new address
  So that I can receive my orders at a different location

  Scenario Outline: Add new address
    Given an open browser
    When I log in with "<email>" and "<password>"
    And I click the Create new address button
    Then I fill in the fields with the following data "<alias>" "<address>" "<city>" "<postcode>" "<phone>"

    Examples:
      | email           | password | alias         | address       | city       | postcode | phone        |
      | patroz@abc.pl   | patroz   | Home Address  | 1234 Main St  | Anytown    | 12345    | 555-555-5555 |
      | patroz@abc.pl   | patroz   | Work Address  | 5678 Park Ave | Anycity    | 54321    | 555-555-5556 |
      | patroz@abc.pl   | patroz   | Vacation Home | 12 Elm St     | Beachville | 11111    | 555-555-5557 |
