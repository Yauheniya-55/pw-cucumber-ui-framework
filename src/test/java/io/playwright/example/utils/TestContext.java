package io.playwright.example.utils;

import com.microsoft.playwright.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class TestContext extends LoggingUtil {
    protected static Playwright playwright;
    protected static Browser browser;

    protected BrowserContext browserContext;
    protected Page page;

    @BeforeAll
    public static void beforeAll() {
        String browserType = (System.getProperty("browser"));
        playwright = Playwright.create();
        switch (browserType) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(Boolean.parseBoolean(System.getProperty("headless")))
                        .setSlowMo(250));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                        .setHeadless(Boolean.parseBoolean(System.getProperty("headless")))
                        .setSlowMo(250));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
                        .setHeadless(Boolean.parseBoolean(System.getProperty("headless")))
                        .setSlowMo(250));
                break;
        }
    }

    @AfterAll
    public static void afterAll() {
        browser.close();
        playwright.close();
    }

    public Browser getBrowser() {
        return browser;
    }

}
