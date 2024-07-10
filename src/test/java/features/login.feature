Feature: Login functionality

  Background:
    Given User is on Application  Page

  @Regression
  Scenario: Login with valid user credentials
    When User enters Username "admin@yourstore.com" and Password "admin"
    And User clicks on Sign In button
    Then User navigates to Home Page

@Regression
  Scenario: Login with invalid user credentials
    When User enters Username "admin@yourstore.com" and Password "Admin"
    And User clicks on Sign In button
    Then User navigates to Login Page


  Scenario: Login with valid user credentials - Data Table
    When User enters valid username and password
      | admin@yourstore.com | admin |
    And User clicks on Sign In button
    Then User navigates to Home Page

  Scenario Outline: Login with user credentials
    Given User enters Username "<Username>" and Password "<Password>"
    And   User clicks on Sign In button
    Then Verify the title "<Page title>"
    Examples:
      | Username            | Password | Page title                             |
      | admin@yourstore.com | admin    | Dashboard / nopCommerce administration |
      | admin@yourstore.com | admin1   | Your store. Login                      |


  Scenario Outline: Verify login functionality with multiple users (from Excel sheet)
    Given User enters valid data from sheet "<sheetName>" and rowNumber <rowNumber>
    And User clicks on Sign In button
    Then Page title from sheet "<sheetName>" and rowNumber <rowNumber> should be verified
    Examples:
      | sheetName | rowNumber |
      | login     | 0         |
      | login     | 1         |
