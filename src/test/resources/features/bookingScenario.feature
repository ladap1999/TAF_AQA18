Feature: test for booking.com

  Background:
    Given searchHotelPage is opened
    And user enter the name of hotel
    And user click searchButton

  Scenario Outline: search hotel test
    Then hotel name "<hotelName>" is displayed
    Examples:
      | hotelName                                 |
      | Victoria Regent Waterfront Hotel & Suites |
      | Red Lion Inn and Suites Victoria          |

  Scenario: search rating test
    Then hotel Victoria Regent Waterfront Hotel & Suites  has rating "8.9"



