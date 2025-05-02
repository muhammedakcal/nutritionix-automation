Feature: Nutritionix Mobile App Login
  @smoke  @android
  Scenario: Successful login on iOS app
    Given the Nutritionix mobile app is launched
    When I login with username "test.user@example.com" and password "P@ssw0rd123"
    Then I should see the Track page
