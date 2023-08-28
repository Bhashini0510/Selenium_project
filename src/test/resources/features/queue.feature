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
@queue
Feature: Queue Page
  I want to use this template for my feature file

  @pageLaunch
  Scenario Outline: User is able to navigate to Queue using dropdown option
    When User click on Queue from the dropdown
    Then Queue page is displayed
    And heaader Queue is displayed
    And Verify topics covered is displayed with "<topic>" links
    
    Examples:
    |topic|
    |Implementation of Queue in Python,Implementation using collections.deque,Implementation using array,Queue Operations|
    
  @pageLaunch
  Scenario: User is able to navigate to Queue using Get Strated option
    When User click on Get Started button for Queue
    Then Queue page is displayed
    And heaader Queue is displayed
    
    
  @pythoncodeValidation
  Scenario Outline: User is able to try code in Queue page
    Given click on the list of "<links>" from the excel sheet "Queue"
    When User clicks on try here button and enters code from the excel sheet row in the try editor page and clicks on Run
    Then The code is executed and the output from the excel row is displayed on the page
    
    Examples:
    |links|
    |Implementation of Queue in Python,Implementation using collections.deque,Implementation using array,Queue Operations|
    
    
  @practiceQuestionsValidation
  Scenario Outline: User is able to practice questions in Queue page
    Given User is on "Queue" page and click on the "implementation-lists" topic
    When User clicks on Practice Questions link on the left of "Queue" page
    Then Practice Questions page is displayed
    
    
    
  
  