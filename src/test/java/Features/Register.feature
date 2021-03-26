Feature: login and add product
  @Mesut
  Scenario: User login
    Given a web browser is at the Hepsiburada home page
    When verifiy page title "Hepsiburada"
    When the user click dropdown
    And user clicks on the registration item
    Then user sees the registration form
    When user logs in using Username as "test123" and Password "12345!@"
    And user click submit button
    And verification login


Scenario: find product and add Basket
  When user click search area
  And user enters product name "Samsung"
  And user click search button
  Then the user click dropdown
  When user click second page btn
  And select second page first product
  When user add product basket
  Then Delete product in Basket
  And driver close


