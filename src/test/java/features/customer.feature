Feature: Check the customer functionality

  Background:
    Given User is on Application  Page
    When User enters valid credentials
    And User clicks on Sign In button
    Then User navigates to Home Page
    When User clicks on customers menu
    And click on customers Menu Item

  @Regression,@End2End
  Scenario: Add new user
    When click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view configuration message "The new customer has been added successfully"


  Scenario: Add new user without entering a valid email
    When click on Add new button
    Then User can view Add new customer page
    And click on Save button
    Then User can view validation message "'Email' must not be empty."
    And Enter an invalid email
    And click on Save button
    Then User can view validation message "Please enter a valid email address."

  @End2End
  Scenario: Search for an existing email
    When User search for an email
    And click on Search button
    Then User can view the search results

  Scenario: Search for a non-existing email id
    When User search for an email
    And click on Search button
    Then User can view message 'No data available in table'

  @NewSO
  Scenario Outline: Add new users
    When click on Add new button
    Then User can view Add new customer page
    Given User enters Email "<Email>"
    And User enters Firstname "<FirstName>"
    And User enters Lastname "<LastName>"
    And click on Save button
    Then User can view configuration message "The new customer has been added successfully"
    @test
    Examples:
      | Email                   | FirstName | LastName |
      | anandkt11@gmail.com     | Anand     | Kiran    |
      | tennetikiran1@gmail.com | Abhinav   | Shourya  |
    @sanity
    Examples:
      | Email              | FirstName      | LastName |
      | anandkt2@gmail.com | AnandK Tenneti | Kiran    |

  Scenario: Add a new customer - Data Table
    When click on Add new button
    Then User can view Add new customer page
    When User enters Email firstname and lastname
      | vanik@gmail.com | Krishna | Vani |
    And click on Save button
    Then User can view configuration message "The new customer has been added successfully"

  Scenario: Edit the first customer
    When User clicks on the Edit button of a customer row