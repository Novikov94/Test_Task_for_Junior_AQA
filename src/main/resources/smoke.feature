Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check site main functions

    Given Open '<homePage>' of website
    When user clicks on the search button
    And user enters '<city>'
    And user select start date and end date
    And user clicks on the submit button
    Then check that all hotels contain New York
    Then check that this page is first
    Then check date matching.


    Examples:
      | homePage                                 | city     |
      | https://www.booking.com/index.en-gb.html | New York |


  Scenario Outline: login on the site

    Given Open '<homePage>' of website
    When User clicks on Sign in button
    And User enters '<email>'
    And User clicks on continue button
    And User enter '<password>'
    And user clicks on confirm button
    Then Check that user logged in.


    Examples:
      | homePage                                 | email              | password     |
      | https://www.booking.com/index.en-gb.html | user1994@gmail.com | User1994kram |
