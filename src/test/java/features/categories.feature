Feature: Describes about the customer roles in nopcommerce project

  Background:
    Given User is on Application  Page
    When User enters valid credentials
    And User clicks on Sign In button
    Then User navigates to Home Page
    When User clicks on Catalog menu
    And click on Categories Menu Item

  Scenario: Add a new category
    When click on Add new Category button
    And enter details in category info section
    And click on Category Save button
    Then view the message "The new category has been added successfully."

  @CategoriesSO
  Scenario Outline: Search for category names
    Given Search for category name "<category>"
    And click on Search button for categories
    Then view the category search results

    Examples:
      | category  |
      | Computers |
      | Apparel   |