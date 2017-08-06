Feature: Navigation

  Background:
    When I go to http://www.valtech.com

  Scenario: Homepage displays latest news
    Then the LATEST NEWS section is displayed

  Scenario Outline: Pages display correct headers
    When I navigate to the <pageName> page
    Then the <pageName> header is displayed

    Examples:
      | pageName |
      | ABOUT    |
      | SERVICES |
      | WORK     |

  Scenario: Calculate number of Valtech offices
    When I open the contact page
    Then all of the Valtech offices will be displayed