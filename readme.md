## To be installed locally

- JDK version at least 8;
- Maven;
- IntelliJ Idea
- Cucumber and Gherkin plugins

Before running tests:
```
wait until maven resolve all the dependencies, or resolve dependencies manually
```
## Running the tests locally

Tests execution on local machine in chromium head mode will start by the command:
```
mvn -Dbrowser=chromium -Dheadless=false clean test
```
Available options for browser variable: chromium/firefox/webkit
Available options for headless variable: true/false
