@regression
Feature: Testing the Login Functionality

  @smoke
  Scenario: Happy path Login
    When User provides email 'guest1@microworks.com', password 'Guest1!' and Click Login Button
    Then User validates title 'ORDER DETAILS - Weborder'


  Scenario Outline: Negative Login
    When User provides email '<email>', password '<password>' and Click Login Button
    Then User validates the message '<message>' and background-color '<background-color>'

    Examples:
      | email                 | password | message        | background-color       |
      | guest1@microworks.com | asdsdfd  | Sign in Failed | rgba(248, 215, 218, 1) |
      | asdasd@microworks.com | Guest1!  | Sign in Failed | rgba(248, 215, 218, 1) |
      |                       |          | Sign in Failed | rgba(248, 215, 218, 1) |