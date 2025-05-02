@smoke @ios @android @Smart_Search
Feature: Smart Search suggestions and logging

  Background:
    Given I open the "Custom Foods" screen

  Scenario Outline: Log a food via Smart Search
    When I switch to the "<section>" section
    And I type "<query>" into the search bar
    And I select Free Form: "<query>"
    And I click on: "Log 1 Food"
    Then the "<food>" item should appear under the "<section>" section with quantity <qty>

  Examples:
    | query        | food    | section | qty |
    | 2 bananas    | Bananas | LUNCH   | 2   |
    | 150g chicken | Chicken | DINNER  | 1   |