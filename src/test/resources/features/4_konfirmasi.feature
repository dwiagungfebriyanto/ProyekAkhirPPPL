Feature: Konfirmasi permintaan peminjaman

  Background: User login as laboran
    Given user is on the login page
    And user submits valid laboran credentials

  Scenario Outline: Successfully search with id or name
    Given user is on the Permintaan Peminjaman page
    When user searches for a "<keyword>"
    Then tool loan requests that match the "<keyword>" will appear

  Examples:
    | keyword               |
    | 1                     |
    | Viko                  |

  Scenario Outline: User searches for names and ids that are not in the list
    Given user is on the Permintaan Peminjaman page
    When user searches for a "<keyword>"
    Then no data displayed that matches the "<keyword>"

  Examples:
    | keyword               |
    | 1000000               |
    | Ajeng CE              |

  Scenario: User approves a pending tool loan request
    Given user is on the Permintaan Peminjaman page
    And user views loan requests that are still on pending status
    When user approves the tool loan request
    Then the approved message will appear

  Scenario: User rejects a pending tool loan request
    Given user is on the Permintaan Peminjaman page
    And user views loan requests that are still on pending status
    When user rejects the tool loan request
    Then the rejected message will appear