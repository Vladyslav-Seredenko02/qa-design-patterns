## What Was Implemented

1. WebDriverManager for managing drivers for different browsers - DONE.
2. PageObject / PageFactory for abstract pages - DONE.
   COMMENT: Implemented BasePage as abstract base class with common methods and WebDriverWait.
   LoginPage, InboxPage, DraftPage extend BasePage and use @FindBy with PageFactory.initElements.
3. Necessary business model (business objects for dedicated entities) - DONE.
   COMMENT: TestData class holds test data constants loaded from property files via ConfigReader.
4. Property files with test data for different environments (at least 2) - DONE.
   COMMENT: qa1.properties and qa2.properties are located in src/test/resources/config/.
   Environment is selected via Maven parameter: mvn test -Denv=qa2.
5. XML suites for Smoke and Regression tests - DONE.
   COMMENT: smoke.xml, regression.xml, and crossBrowser.xml are located in src/test/resources/suits/.
6. Possibility to make a screenshot in case of test failure - DONE.
   COMMENT: Implemented in AllureListener which implements ITestListener.
   On test failure, a screenshot is taken and attached to the Allure report.
   Log contains information about the saved screenshot.
7. Flexibility on different parameters (browser, test suite, environment) - DONE.
   COMMENT: All parameters are passed via Maven command line:
   mvn clean test -Dsuite=regression -Dbrowser=firefox -Denv=qa2
8. Logging with Log4j2 - DONE.
   COMMENT: Logs are written to both console and file simultaneously.
   A new log file is created for each day in the logs/ directory.
   Log levels used: INFO, DEBUG, ERROR.
   Log format includes timestamp, thread, level, logger name and message.
9. Test results on job graphics and screenshots archived as artifacts - DONE.
   COMMENT: Allure Report plugin is configured in Jenkins.
   Jenkins build screenshots are available in jenkins-report/ folder.

## How to run

Default run:
'mvn clean test'

With parameters:
'mvn clean test -Dsuite=smoke -Dbrowser=firefox -Denv=qa2'

Available parameters:

| Parameter |             Values              |      Default      |
|:---------:|:-------------------------------:|:-----------------:|
|   suite   | smoke, regression, crossBrowser | regression, smoke |
|  browser  |      chrome, firefox, edge      |  firefox, chrome  |
|    env    |            qa1, qa2             |        qa1        |

Allure Report:
'mvn allure:serve'