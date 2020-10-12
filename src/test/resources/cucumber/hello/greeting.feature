Feature: Greeting

  Scenario: A specified name is greeted
    Given "John" was set to be greeted
    When "John" is asked to be greeted
    Then "Hey, John" should be said

  Scenario: It's informed there's no one with a given name to be greeted
    Given "John" was set to be greeted
    When "Julia" is asked to be greeted
    Then "There is no name Julia" should be said
