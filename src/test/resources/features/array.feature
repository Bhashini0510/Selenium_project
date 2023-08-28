@array
Feature: Array Page
  I want to use this template for my feature file

  @pageLaunch
  Scenario Outline: User is able to navigate to Array using dropdown option
    When User click on Array from the dropdown
    Then Array page is displayed
    And heaader Array is displayed
    And Verify topics covered is displayed with "<topic>" links  
    
  Examples:
    |topic|
    |Arrays in Python,Arrays Using List,Basic Operations in Lists,Applications of Array|
    
  @pageLaunch
  Scenario: User is able to navigate to Array using Get Strated option
    When User click on Get Started button for Array
    Then Array page is displayed
    And heaader Array is displayed
    
    
  @pythoncodeValidation
  Scenario Outline: User is able to try code in Array page
    Given click on the list of "<links>" from the excel sheet "Arrays"
    When User clicks on try here button and enters code from the excel sheet row in the try editor page and clicks on Run
    Then The code is executed and the output from the excel row is displayed on the page
    
    Examples:
    |links|
    |Arrays in Python,Arrays Using List,Basic Operations in Lists,Applications of Array|
    
  @practiceQuestionsValidation
  Scenario Outline: User is able to practice questions in Array page
    Given click on the list of "links" from the excel sheet "Practice"
    When User clicks on Practice Questions link on the left of page
    Then User is able to run and submit practice codes
    
    
  

