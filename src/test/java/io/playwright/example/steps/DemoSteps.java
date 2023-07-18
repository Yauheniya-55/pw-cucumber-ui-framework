package io.playwright.example.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.playwright.example.pages.GetStartedPage;
import io.playwright.example.utils.LoggingUtil;
import io.playwright.example.utils.TestContext;

public class DemoSteps {
    private final TestContext testContext;
    private final LoggingUtil loggingUtil;
    private final Browser browser;
    private BrowserContext browserContext;
    private Page page;

    public DemoSteps(TestContext testContext, LoggingUtil loggingUtil) {
        this.testContext = testContext;
        this.browser = testContext.getBrowser();
        this.loggingUtil = loggingUtil;
    }

    @Before
    public void createContextAndPage() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @After
    public void closeContext() {
        browserContext.close();
    }


    @Given("I navigate to {string} page")
    public void navigateToPage(String desiredUrl) {
        GetStartedPage demoPage = new GetStartedPage(page);
        demoPage.navigate(desiredUrl);
    }

    @Then("I verify start page is loaded by 'Get Started' button is displayed")
    public void verifyStartPageIsLoaded() {
        new GetStartedPage(page).assertGetStartedButtonIsVisible();
    }

    @And("I verify 'Search' button is displayed on navigation panel")
    public void verifySearchButtonIsDisplayedOnNavigationPanel() {
        new GetStartedPage(page).assertSearchButtonIsVisible();
    }

    @When("I click 'Search' button on navigation panel")
    public void clickSearchButtonOnNavigationPanel() {
        new GetStartedPage(page).clickSearch();
    }

    @Then("I verify 'Document search' modal is displayed")
    public void verifyDocumentSearchModalIsDisplayed() {
        new GetStartedPage(page).assertSearchModalIsVisible();
    }

    @When("I populate 'Document search' modal with {string} text")
    public void populateDocumentSearchModalWithText(String textToSearch) {
        new GetStartedPage(page).populateSearchInput(textToSearch);
    }

    @Then("I verify 'Document search' input is populated with {string} text")
    public void verifySearchInputIsPopulatedWithText(String text) {
        new GetStartedPage(page).assertSearchInputIsPopulated(text);
    }

    @And("I verify there is a search result hit with value {string} under search being marked")
    public void verifySearchResultHitMarked(String searchTitle) {
        new GetStartedPage(page).assertFirstSearchHitIsVisible(searchTitle);

    }
}
