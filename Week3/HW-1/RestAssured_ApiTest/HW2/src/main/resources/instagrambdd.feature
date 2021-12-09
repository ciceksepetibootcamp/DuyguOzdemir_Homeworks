Feature: Instagram Tests(login-SearchUser)

    @positive
    Scenario Outline:
      Given Navigate to Instagram
      When User should enter user information "<userName>"
      And User should enter pass information "<password>"
      And User should click LogIn button.
      Then User should verify succeed logIn "Save your login information?"

      Examples:
        | userName                 | | password     |
        |testuserbootcamp@gmail.com| |Cs_123bcamp_123|


  @negative
  Scenario Outline:
    Given Navigate to Instagram
    When User should enter user information "<userName>"
    And User should enter pass information "<password>"
    And User should click LogIn button.
    Then User should verify failed LogIn result "Sorry, your password was incorrect. Please double-check your password."
    Examples:
      | userName                 | | password     |
      |testuserbootcamp@gmail.com| |failed_123|


  @positive
  Scenario Outline:
    Given Navigate to Instagram
    When User should enter user information "<userName>"
    And User should enter pass information "<password>"
    And User should click LogIn button.
    Then User should verify succeed logIn "Save your login information?"
    Then User should search someone's account "<searchUser>"

    Examples:
      | userName                 | | password  |searchUser|
      | testuserbootcamp@gmail.com| | Cs_123bcamp_123  |   jlo     |
