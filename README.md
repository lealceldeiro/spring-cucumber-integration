# "Hello App": A Spring Boot - Cucumber integration demo application

A simple "Hello App" to show how to integrate a Spring Boot Application along with unit tests and Cucumber tests using Maven as build tool.

## Run Cucumber tests

From the current directory run

`mvn clean test -Dtest=CucumberTestRunner`

Optionally you can add to the previous command `-Dcucumber.filter.tags="@tag1 and @tag2"`

where:

- `CucumberTestRunner` is the test runner class
- `cucumber.filter.tags` specifies the tag(s) used to mark the test(s) to be ran (it should be omitted to run all tests)

For more info on this see [Cucumber Docs](https://cucumber.io/docs/cucumber/)
