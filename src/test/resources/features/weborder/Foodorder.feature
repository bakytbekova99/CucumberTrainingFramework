@regression
Feature: Testing Food Order Functionality
  Background: Repeating Steps for login, title, group order, invitees section, invite lest
    When User provides email 'guest1@microworks.com', password 'Guest1!' and Click Login Button
    And User validates title 'ORDER DETAILS - Weborder'
    And User clicks Group Order Box and Next Button
    And User sends the word 'I love Cucumber' for note to the Invitees Section
    And User sends e-mail address which are 'aliyah@gmail.com' and 'david@gmail.com' to the invite list

  Scenario: Validating Group Food Order Functionality
    And User chooses delivery address 'My House' and validates the address '3137 Laguna'
    And User clicks the create group order button
    Then User validates the header of the page 'View Group Order'
    And User validates the word 'Your group order is now pending' from description

  Scenario: Validating Group Food Order Functionality for Office
    And User chooses delivery address 'Office' and validates the address '2012 EMPIRE'
    And User clicks the create group order button
    Then User validates the header of the page 'View Group Order'
    And User validates the word 'Your group order is now pending' from description