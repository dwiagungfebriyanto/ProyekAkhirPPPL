Feature: Student Register

  Scenario: Successful register with valid credentials
    Given user is on the register page
    When user submits valid credentials on account details
    And user submits valid credentials on personal information
    Then user should see a confirmation message

  Scenario Outline: Student register with invalid credentials on account details
    Given user is on the register page
    When user submits "<email>", "<phone>", "<password>", and "<passwordConfirmation>"
    Then user cannot proceed to the personal information section

  Examples:
    | email             | phone           | password        | passwordConfirmation  |
    |                   | 081234563456    | password        | password              |
    | siswa@mail.com    | 081234563456    |                 | password              |
    | siswa@mail.com    | 081234563456    | password        |                       |
    | siswa@mail.com    |                 | password        | password              |

  Scenario Outline: Student register with invalid credentials on personal information section
    Given user is on the register page
    When user submits valid credentials on account details
    And user submits "<name>", "<nisn>", "<class>", "<dateOfBirth>", and "<entryYear>"
    Then user cannot register an account

  Examples:
    | name          | nisn                 | class                           | dateOfBirth         | entryYear         |
    |               | 8347734944           | X Teknik Komputer dan Jaringan  | 12/March/2004       | 2022              |
    | student       |                      | X Teknik Komputer dan Jaringan  | 12/March/2004       | 2022              |
    | student       | 8347734944           |                                 | 12/March/2004       | 2022              |
    | student       | 8347734944           | X Teknik Komputer dan Jaringan  |                     | 2022              |
    | student       | 8347734944           | X Teknik Komputer dan Jaringan  | 12/March/2004       |                   |