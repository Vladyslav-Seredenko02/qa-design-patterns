## What Was Implemented

### Singleton

`DriverFactory` ensures only one `WebDriver` instance exists during the test run.
A private constructor prevents external instantiation.

### Factory Method

Abstract class `BrowserDriver` defines the `createDriver()` method. And each browser has its own implementation:
`ChromeBrowserDriver`,
`EdgeBrowserDriver`,
`FirefoxBrowserDriver`.

And `DriverFactory` class, in turn, delegates driver creation to these classes without knowing
the details of each implementation.

### Decorator

`MailService` interface is implemented by `InboxPage` (original) and `LoggingMailService` (decorator).
`LoggingMailService` wraps the original `MailService` object and adds logging before delegating each call to the original implementation.

### S.O.L.I.D. Fixes

|       Class       |                             Problem                              | Principle |                              Solution                               |
|:-----------------:|:----------------------------------------------------------------:|:---------:|:-------------------------------------------------------------------:|
|  `DriverFactory`  |      Adding a new browser required modifying existing class      |    OCP    | Extracted browser creation into separate `BrowserDriver` subclasses |
|    `InboxPage`    |       `fillEmailForm()` was hardcoded to `TestData` class        |    DIP    |               Data is now passed as method parameters               |
| `AllureListener ` | Responsible for both handling test events and taking screenshots |    SRP    |     Screenshot logic moved to dedicated `ScreenshotUtils` class     |

## How to run

Default run:
`mvn clean test`

With parameters:
`mvn clean test -Dsuite=smoke -Dbrowser=firefox -Denv=qa2`

Available parameters:

| Parameter |             Values              |      Default      |
|:---------:|:-------------------------------:|:-----------------:|
|   suite   | smoke, regression, crossBrowser | regression, smoke |
|  browser  |      chrome, firefox, edge      |  firefox, chrome  |
|    env    |            qa1, qa2             |        qa1        |


Allure Report:
`mvn allure:serve`