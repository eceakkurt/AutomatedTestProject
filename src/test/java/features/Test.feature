Feature: Create New Account functionality

  @CreateAccount

  Scenario: New Account Create
    Given Start Driver and Browser
    And Navigate To Url
    And Click Sign In
    And Email Write
    And Click Create An Account
    And Fill Personal Information Form
    And Click Register
    And Check Account
    And Click Dresses
    And Click Add To Cart
    And Click Continue Shopping
    And Search Text
    And Add To Cart
    And Click Cart Checkout
    And Check Cart
    And Process Address
    And Process Shipping
    And Process Payment
    And Check Order
    Then Close Driver and Browser