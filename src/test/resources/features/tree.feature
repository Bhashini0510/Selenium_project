@tree
Feature: Tree Page
  I want to use this template for my feature file

  @pageLaunch
  Scenario Outline: User is able to navigate to Tree using dropdown option
    When User click on Tree from the dropdown
    Then Tree page is displayed
    And heaader Tree is displayed
    And Verify topics covered is displayed with "<topic>" links
    
    Examples:
    |topic|
    |Overview of Trees,Terminologies,Types of Trees,Tree Traversals,Traversals-Illustration,Binary Trees,Types of Binary Trees,Implementation in Python,Binary Tree Traversals,Implementation of Binary Trees,Applications of Binary trees,Binary Search Trees,Implementation Of BST|
    
  @pageLaunch
  Scenario: User is able to navigate to Tree using Get Strated option
    When User click on Get Started button for Tree
    Then Tree page is displayed
    And heaader Tree is displayed
    
    
  @pythoncodeValidation
  Scenario Outline: User is able to try code in Tree page
    Given click on the list of "<links>" from the excel sheet "Tree"
    When User clicks on try here button and enters code from the excel sheet row in the try editor page and clicks on Run
    Then The code is executed and the output from the excel row is displayed on the page
    
    Examples:
    |links|
    |Overview of Trees,Terminologies,Types of Trees,Tree Traversals,Traversals-Illustration,Binary Trees,Types of Binary Trees,Implementation in Python,Binary Tree Traversals,Implementation of Binary Trees,Applications of Binary trees,Binary Search Trees,Implementation Of BST|
    
    
  @practiceQuestionsValidation
  Scenario Outline: User is able to practice questions in Tree page
    Given User is on "Tree" page and click on the "Traversals-Illustration" topic
    When User clicks on Practice Questions link on the left of "Tree" page
    Then Practice Questions page is displayed
    
    
  
