Feature: test for saucedemo.com

  Background:
    Given open browser
    * loginPage is opened

  Scenario: end-to-end test
    When user "standard_user" with password "secret_sauce" logged in
    * user adds an item to the cart
    * user follows to the cartPage
    * user follows to the checkoutPage
    * user fills payment information fields: name "Alex", secondName "Popov", zipCode "220106"
    * user completes payment
    Then page ListOfProduct is opened


