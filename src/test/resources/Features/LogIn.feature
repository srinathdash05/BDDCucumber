Feature: Login

  Scenario Outline: Login to site
    Given User is on login page
    When user enters <username> and <password>
    And Click on Log in button
    Then Navigated to the landing page

    Examples: 
      | username             | password  |
      | agent@phptravels.com | demoagent |
