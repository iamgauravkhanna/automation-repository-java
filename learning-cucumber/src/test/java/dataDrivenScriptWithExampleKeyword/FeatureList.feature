Feature: Smoke Test of Project

In order to continue my work smoke test of project should pass

Scenario Outline: Verify sanity scenario should run successfully

Given I open the browser
When I click on "Chapter1"
And I select "<DropDownValue>" in drop down  	
Then My test should pass
Examples:
    | DropDownValue   |
    | Selenium IDE |
    | Selenium Core |
    | Selenium RC |