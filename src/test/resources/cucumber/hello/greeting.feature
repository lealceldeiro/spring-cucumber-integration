Feature: Greeting

  Scenario: A specified name is greeted
    Given "John" is to be greeted
    When There is a greeting
    Then "Hello, John" should be said

  Scenario: It is informed there is no one to be greeted
    Given There is no one to be greeted
    When There is a greeting
    Then "There is no one to greet" should be said
