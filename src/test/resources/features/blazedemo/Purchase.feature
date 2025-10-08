#This is the place where we write our test cases
  # Feature is a general description of the test case

Feature: Testing the Purchase Functionality
  # Background is like BeforeMethod in feature file. It runs before every scenario
  Background: Repeating first 3 step (navigation, departure, destination)
#    Given User navigates to the 'https://www.blazedemo.com/'
    When User chooses 'Boston' for departure
    And User chooses 'London' for destination and clicks Finding Flight button
  #Scenario is a test case
  Scenario: Validating finding flights functionality
    #Given is a precondition
#  Given User navigates to the 'https://www.blazedemo.com/'
#    #When is about action
#    When User chooses 'Boston' for departure
#    #And is continues action
#    And User chooses 'London' for destination and clicks Finding Flight button
#    #Then is results of action (validation)
    Then User validates the header 'Flights from Boston to London:'

    Scenario: Validating purchase ticket functionality
#      Given User navigates to the 'https://www.blazedemo.com/'
#      When User chooses 'Boston' for departure
#      And User chooses 'London' for destination and clicks Finding Flight button
      And User chooses the first flight
      And User provides contact information 'Aliyah', '10755 Meadowglen Ln', 'Houston', 'TX', '77042'
      And User provides payment information 'American Express', '1234567891123456', '10', '2028', 'Aliyah Bakytbekova'
      And User selects the Remember Me button and clicks Purchase Flight Button
      Then User validates the message 'Thank you for your purchase today!'

