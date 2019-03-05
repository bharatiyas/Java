## All Test Scenarios will be written in a feature file

Business Need: User Login
  Valid User should be able to login, whereas a invalid user should not be able to login.

  Scenario Outline: Test login using valid credentials
    Given User has opened the login page
    When The user enters username as "<username>" and password as "<password>"
    And The user submits the login page
    Then The user is redirected to the home page
    Examples:
      | username    | password  |
      | bharatiyas  | passbhar  |
      | admin       | admin     |
      | bharatiyasi | passbhari |

  Scenario: Test login using invalid credentials
    Given: User has opened the login page
    When The user enters username as "invalid" and password as "in-password"
    And The user submits the login page
    Then The user remains on login page
    And An could not login error message is displayed
