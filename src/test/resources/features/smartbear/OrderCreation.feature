@regression
Feature: Testing The Order Creation Functionality

  Scenario: Happy Path Order Creation
    Given User provides username 'Tester' and password 'test' and click Login Button
    When User clicks Order Button
    And User provides 'MyMoney' and '4' for the Product Information
    And User provides 'Aliyah', '10755 Meadowglen Ln', 'TX', '77042' for the Address Information
    And User provides 'Visa', '2345678976543456', '11/28' for the Payment Information
    Then User clicks process button and validates 'New order has been successfully added.'
    And User clicks view all orders button and validates 'Aliyah', 'MyMoney' from the list

  Scenario: Happy Path Order Creation - Visa DataTable
    Given User provides username and password and click Login Button
      | username | Tester |
      | password | test   |
    When User clicks Order Button
    And User provides and quantity for the Product Information
      | product  | MyMoney |
      | quantity | 4       |
    And User provides customerName, street, state, zipcode for the Address Information
      | customerName | Aliyah              |
      | street       | 10755 Meadowglen Ln |
      | state        | TX                  |
      | zipcode      | 77042               |
    And User provides card, cardNumber, expireDate for the Payment Information
      | card       | Visa             |
      | cardNumber | 2345678976543456 |
      | expireDate | 11/28            |
    Then User clicks process button and validates message
      | New order has been successfully added. |
    And User clicks view all orders button and validates customerName, product from the list
      | customerName | Aliyah  |
      | product      | MyMoney |

  Scenario Outline: Happy Path Order Creation for All Products + Card Types
    Given User provides username '<username>' and password '<password>' and click Login Button
    When User clicks Order Button
    And User provides '<product>' and '<quantity>' for the Product Information
    And User provides '<customerName>', '<street>', '<state>', '<zipcode>' for the Address Information
    And User provides '<card>', '<cardNumber>', '<expireDate>' for the Payment Information
    Then User clicks process button and validates '<message>'
    And User clicks view all orders button and validates '<customerName>', '<product>' from the list

    Examples:
      | username | password | product     | quantity | customerName | street              | state | zipcode | card             | cardNumber       | expireDate | message                                |
      | Tester   | test     | MyMoney     | 4        | Aliyah       | 10755 Meadowglen Ln | TX    | 77042   | Visa             | 2345678976543456 | 11/28      | New order has been successfully added. |
      | Tester   | test     | FamilyAlbum | 4        | David        | 10755 Meadowglen Ln | TX    | 77042   | MasterCard       | 2345678976543456 | 11/28      | New order has been successfully added. |
      | Tester   | test     | ScreenSaver | 4        | Likosh       | 10755 Meadowglen Ln | TX    | 77042   | American Express | 2345678976543456 | 11/28      | New order has been successfully added. |
