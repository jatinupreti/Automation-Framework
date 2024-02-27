Feature: Verify user can login

  Scenario: Verify User can login into application using valid credentials
	Given I launch 'https://www.saucedemo.com/' url
	Then I verify that user is on login page
	Then I enter 'standard_user' in username field
	And I enter 'secret_sauce' in password field
	When I click on Login button
	Then I should be on Inventory page
	


