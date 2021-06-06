#Author: Arun Babu
#Date : 06/04/2021
@tag
Feature: Login Test
  I wan to test login on my automation test page

  @smoke
  Scenario: Valid Login Test
    Given I navigate to automation practice page
    And I click on Sign In Button
    Then validate Sign In page is displayed
    When enter valid user name and password
    And click Sign in button
    Then Validate if user home page is displayed
