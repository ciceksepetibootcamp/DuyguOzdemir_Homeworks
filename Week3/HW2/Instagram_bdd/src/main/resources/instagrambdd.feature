Feature: Instagram Tests(login-SearchUser)

  Background:
    Given Navigate to Instagram

    @Positive
    Scenario Outline:
      When User Should enter user information "<userName>"
      And User Should enter pass information "<password>"
      Then User Should click LogIn button.
      Examples:
        | userName                 | | password     |
        |testuserbootcamp@gmail.com| |Cs_123bcamp_123|
