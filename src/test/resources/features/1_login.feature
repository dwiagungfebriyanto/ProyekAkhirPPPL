Feature: User Login

  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user submits valid credentials
    Then user should be redirected to the Daftar Alat page

  Scenario Outline: User login with invalid credentials
    Given user is on the login page
    When user submits "<email>" and "<password>"
    Then user still on the login page

  Examples:
    | email               | password        |
    | student@mail.com    | password1       |
    | student1@mail.com   | password        |
    | student1@mail.com   | password1       |
    |                     | password        |
    | student@mail.com    |                 |
    |                     |                 |
