#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@stack
Feature: Stack Page
  I want to use this template for my feature file

  @pageLaunch
  Scenario Outline: User is able to navigate to Stack using dropdown option
    When User click on Stack from the dropdown
    Then Stack page is displayed
    And heaader Stack is displayed
    And Verify topics covered is displayed with "<topic>" links
    
    Examples:
    |topic|
    |Operations in Stack,Implementation,Applications|
    
  @pageLaunch
  Scenario: User is able to navigate to Stack using Get Strated option
    When User click on Get Started button for Stack
    Then Stack page is displayed
    And heaader Stack is displayed
    
    
  @pythoncodeValidation
  Scenario Outline: User is able to try code in Stack page
    Given click on the list of "<links>" from the excel sheet "Stack"
    When User clicks on try here button and enters code from the excel sheet row in the try editor page and clicks on Run
    Then The code is executed and the output from the excel row is displayed on the page
    
    Examples:
    |links|
    |Operations in Stack,Implementation,Applications|
    
    
  @practiceQuestionsValidation
  Scenario Outline: User is able to practice questions in Stack page
    Given User is on "Stack" page and click on the "stack-applications" topic
    When User clicks on Practice Questions link on the left of "Stack" page
    Then Practice Questions page is displayed
    
    