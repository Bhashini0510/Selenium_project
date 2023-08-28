@linkedList
Feature: Linked List Page
  I want to use this template for my feature file

  @pageLaunch
  Scenario Outline: User is able to navigate to Linked List using dropdown option
    When User click on Linked List from the dropdown
    Then LinkedList page is displayed
    And heaader Linked List is displayed
    And Verify topics covered is displayed with "<topic>" links
    
    Examples:
    |topic|
    |Introduction,Creating Linked LIst,Types of Linked List,Implement Linked List in Python,Traversal,Insertion,Deletion|
    
  @pageLaunch
  Scenario: User is able to navigate to Linked List using Get Strated option
    When User click on Get Started button for Linked List
    Then LinkedList page is displayed
    And heaader Linked List is displayed
        
  @pythoncodeValidation
  Scenario Outline: User is able to try code in Linked list page
    Given click on the list of "<links>" from the excel sheet "LinkedList"
    When User clicks on try here button and enters code from the excel sheet row in the try editor page and clicks on Run
    Then The code is executed and the output from the excel row is displayed on the page
     Examples:
    |links|
    |Introduction,Creating Linked LIst,Types of Linked List,Implement Linked List in Python,Traversal,Insertion,Deletion|
  @practiceQuestionsValidation
  Scenario Outline: User is able to practice questions in Linked list page
    Given User is on "Linked List" page and click on the "introduction" topic
    When User clicks on Practice Questions link on the left of "Linked List" page
    Then Practice Questions page is displayed
    
    
  
