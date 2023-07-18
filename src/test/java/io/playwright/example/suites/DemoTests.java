package io.playwright.example.suites;

import org.junit.platform.suite.api.*;


@Suite
@SuiteDisplayName("Test Use Cases")
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
//@IncludeTags("Validation") // For a custom tags run
//@ConfigurationParameter(key = "io.playwright.steps", value = "steps")
public class DemoTests {
}
