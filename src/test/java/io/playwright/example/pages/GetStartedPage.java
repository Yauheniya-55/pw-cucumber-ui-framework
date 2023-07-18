package io.playwright.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

public class GetStartedPage {
    private final Page page;
    private final Locator getStartedButton;
    private final Locator searchButton;
    private final Locator docSearchModal;
    private final Locator searchInput;
    private final Locator searchHitList;

    public GetStartedPage(Page page) {
        this.page = page;
        this.getStartedButton = page.locator("[class='getStarted_Sjon']");
        this.searchButton = page.locator("[class='DocSearch-Button-Container']");
        this.docSearchModal = page.locator("[class='DocSearch-Modal']");
        this.searchInput = page.locator("[class='DocSearch-Input']").nth(0);
        this.searchHitList = page.locator(".DocSearch-Hit-title mark");
    }

    public void navigate(String url){
        page.navigate(url);
    }

    public void assertSearchButtonIsVisible(){
        Assertions.assertTrue(searchButton.isVisible(), "Failed to locate 'Search' button on navigation panel");
    }
    public void clickSearch(){
        searchButton.click();
    }

    public void assertGetStartedButtonIsVisible(){
        Assertions.assertTrue(getStartedButton.isVisible(), "Failed to locate 'Get Started' button on start page");
    }

    public void assertSearchModalIsVisible(){
        Assertions.assertTrue(docSearchModal.isVisible(), "Failed to locate 'Search docs' modal");
    }

    public void populateSearchInput(String desiredValue){
        searchInput.fill(desiredValue);
    }

    public void assertSearchInputIsPopulated(String withText){
        Assertions.assertTrue(searchInput.getAttribute("value").contains(withText),
                "Failed to populate 'Search' modal with value " + withText);
    }

    public void assertFirstSearchHitIsVisible(String searchValue){
        String [] marked = searchHitList.allInnerTexts().toArray(new String[0]);
        Assertions.assertTrue(searchHitList.first().innerText().contains(searchValue));
    }
}