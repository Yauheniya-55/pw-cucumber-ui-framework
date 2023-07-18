Feature: Search for documentation

  @Smoke
  Scenario Outline: As a User I am able to search for documentation
    Given I navigate to <URL> page
    Then I verify start page is loaded by 'Get Started' button is displayed
    And I verify 'Search' button is displayed on navigation panel
    When I click 'Search' button on navigation panel
    Then I verify 'Document search' modal is displayed
    When I populate 'Document search' modal with <DESIRED_TEXT> text
    Then I verify 'Document search' input is populated with <DESIRED_TEXT> text
    And I verify there is a search result hit with value <DESIRED_TEXT> under search being marked

    Examples:
      | URL                      | DESIRED_TEXT |
      | "https://playwright.dev" | 'Java'       |

