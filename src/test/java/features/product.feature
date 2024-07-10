Feature: Check the functionality of a product

  Background:
    Given User is on Application  Page
    When User enters valid credentials
    And User clicks on Sign In button
    Then User navigates to Home Page
    When User clicks on Catalog menu
    And click on Products Menu Item

  @Regression
  Scenario: Add new product - Basic
    When click on Add new product button
    Then User can view 'Add a new product' page
    When User enter product info and click on Save button
    Then User can view product configuration message "The new product has been added successfully"

  @End2End
  Scenario: Search for a non-existing product
    When User search for a product
    And click on Product Search button
    Then User can view the product message 'No data available in table'

  @Validation
  Scenario: Add new product without entering a product name
    When click on Add new product button
    Then User can view 'Add a new product' page
    And click on Product Save button
    Then User can view product validation message "Please provide a name."

  @NewSO
  Scenario Outline: Add new products
    When click on Add new product button
    Then User can view 'Add a new product' page
    Given User enters Product name "<ProductName>"
    And User enters Short description "<ShortDescription>"
    And click on Product Save button
    Then User can view product configuration message "The new product has been added successfully"
    Examples:
      | ProductName | ShortDescription | FullDescription |
      | MacBook     | Apple            | Apple 8GB       |
      | Windows10   | About Win10      | Win 10 details  |

  Scenario: Add new products - Data Table
    When click on Add new product button
    Then User can view 'Add a new product' page
    When User enters productName short description
      | linux OS | Linux OS has different flavors |
    And click on Product Save button
    Then User can view product configuration message "The new product has been added successfully"