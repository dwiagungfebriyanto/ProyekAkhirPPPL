Feature: Cart

  Background: User login as student
    Given user is on the login page
    And user submits valid credentials

  Scenario: Successful add one item to the cart
    Given user is on the Daftar Alat Page
    When user adds one item to the cart
    Then the item is on the cart

  Scenario: User adds an item that is already in the cart
    Given user is on the Daftar Alat Page
    When user has one item in the cart
    Then user cannot add the same item to the cart

  Scenario: Successfully submit a tool loan request
    Given user is on the Cart page
    When user has one item in the cart
    And user submits valid required data
    Then a tool loan request should be sent

  Scenario Outline: Failed to submit a tool loan request with invalid data
    Given user is on the Cart page
    When user has one item in the cart
    And user submits: "<numberOfTools>", "<borrowingDate>", "<returnDate>", "<subject>", and "<notes>"
    Then a tool loan request should not be sent

  Examples:
    | numberOfTools    | borrowingDate   | returnDate      | subject                      | notes           |
    | 10000            | 1/July/2024     | 2/July/2024     | Algoritma dan Struktur Data  | Testing         |
    | -1               | 1/July/2024     | 2/July/2024     | Algoritma dan Struktur Data  | Testing         |
    | 1                | 1/June/2024     | 2/June/2024     | Algoritma dan Struktur Data  | Testing         |
    | 1                |                 | 2/July/2024     | Algoritma dan Struktur Data  | Testing         |
    | 1                | 1/July/2024     |                 | Algoritma dan Struktur Data  | Testing         |
    | 1                | 1/July/2024     | 2/July/2024     | Algoritma dan Struktur Data  |                 |
    | 1                |                 |                 |                              |                 |

  Scenario: Successfully submit a tool loan request with empty subject
    Given user is on the Cart page
    And user has one item in the cart
    When user submits valid required data without subject
    Then a tool loan request should be sent

  Scenario: Successful delete an item in the cart
    Given user is on the Cart page
    When user has one item in the cart
    And user deletes an item
    Then the item should not be in the cart

  Scenario: Failed to submit a tool loan request with empty cart
    Given user is on the Cart page
    And the cart is empty
    When user submits valid required data
    Then a tool loan request should not be sent