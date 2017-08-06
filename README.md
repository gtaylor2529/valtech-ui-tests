# Valtech UI Tests

This project contains the UI tests for the Valtech web application.

The project is a Maven project and the choice of programming language is Java.

The Cucumber test tool has been used to write test features and scenarios.

All UI tests run using Selenium and in this case only the ChromeDriver has been implemented.

## Requirements

- Must have Java installed (https://java.com/en/download/)
- Must have Maven installed (https://maven.apache.org/install.html)
- Must have Google Chrome installed (https://www.google.co.uk/chrome/browser/desktop/index.html)
- Must have checked out the project from GitHub (https://github.com/gtaylor2529/valtech-ui-tests)

## Running Tests

The tests can be executed in two ways:

- Right click the GenericRunner class in the 'src/test/java/runners/' directory and click run

OR

- Run the following command in terminal: 'mvn clean install -Dtest=GenericRunner'

## Test Reports

The reports for the tests can be found in the following directory:
'target/cucumber/index.html'