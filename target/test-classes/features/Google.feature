Feature: Testing google functionalities

  Scenario: Happy path Google search functionality
    Given I navigate to google.com
    When i search for Techtorial
    Then i get more than 100 links on the google page
