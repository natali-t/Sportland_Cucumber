Feature: test boys football shoes from Sportland site

  Scenario: filter and print boys football shoes below 50 EUR
    Given open "www.sportland.lv" home page
    When we choose menu
    Then we can choose products
    Then can choose zeni and futbols
    Then can sort by izpardosana
#    Then can select filters:
#      |APAVI_IEKSTELPAM|
#      |ADIDAS|
    Then can check sorted products have correct brand name
    Then can check all sorted products are on sale
    Then can create and save text and json file with prod. <50EUR

#  Users/natali/Development/Sportland_Cucumber/src/test/java/stepDefs
