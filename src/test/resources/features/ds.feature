@ds
Feature: Linked List Page
  I want to use this template for my feature file

  @pageLaunch
  Scenario Outline: User is able to navigate to Datastructure using Get Strated option
    When User click on Get Started button for Datastructure
    Then Data Structures-Introduction page is displayed
    And heaader Data Structures-Introduction is displayed
    And Verify topics covered is displayed with "<topic>" links
    
    Examples:
    |topic|
    |Time Complexity|
        
  @pythoncodeValidation
  Scenario Outline: User is able to try code in Datastructure page
    Given click on the list of "<links>" from the excel sheet "Datastructure"
    When User clicks on try here button and enters code from the excel sheet row in the try editor page and clicks on Run
    Then The code is executed and the output from the excel row is displayed on the page
     Examples:
    |links|
    |Time Complexity|
    
  @practiceQuestionsValidation
  Scenario Outline: User is able to practice questions in Linked list page
    Given User is on "Datastructure" page and click on the "Time-Complexity" topic
    When User clicks on Practice Questions link on the left of "Datastructure" page
    Then Practice Questions page is displayed
    
    
  
