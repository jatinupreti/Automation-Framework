Feature: User is able to Add products To cart

  Scenario: Verify User is able to add products to cart
    Given I launch 'https://www.saucedemo.com/' url
    Then I verify that user is on login page
    Then I enter 'standard_user' in username field
    And I enter 'secret_sauce' in password field
    When I click on Login button
    Then I should be on Inventory page
    And I apply 'Price (low to high)' filter to sort products
    Then I click on Add to Cart button
