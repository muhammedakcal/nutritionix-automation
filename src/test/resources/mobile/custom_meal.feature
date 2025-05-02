@regression @ios @CustomMeal
Feature: Create and Log Custom Meals

  Background:
    Given I open the "Custom Foods" screen

  Scenario: User creates a new custom meal and logs it
    When I click on + button
    And I enter the following fields:
      | Food Name*           | Power Veggie Salad |
      | Serving Info*        | 1                  |
      | Calories*            | 350                |
      | Total Fat            | 20                 |
      | Saturated Fat        | 3                  |
      | Cholesterol          | 15                 |
      | Sodium               | 420                |
      | Total Carbohydrate   | 35                 |
      | Dietary Fiber        | 8                  |
      | Sugars               | 6                  |
      | Protein              | 10                 |
      | Vitamin A            | 120                |
      | Vitamin C            | 80                 |
      | Vitamin D            | 15                 |
      | Calcium              | 30                 |
      | Iron                 | 12                 |
      | Phosphorus           | 25                 |
      | Potassium            | 450                |
    And I tap the "Submit" button
    Then I confirm adding the custom meal "Power Veggie Salad"
