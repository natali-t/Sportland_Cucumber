Feature: test boys football shoes from Sportland site
  Scenario: filter and print boys football shoes below 50 EUR
    Given open "url" home page
    When we choose menu
    Then we choose products
    And choose boys
    And choose football
    And sort by sale
    And select filters:
        |ADIDAS|

#    #1.Go to sportland.lv
##2. menu=> products
##3. zēni -> futbols (apavi)
##4. sort by izpārdošana
##5. select some filters
##6. check that all sorted products have correct brand name
#7. check that all sorted products are on sale
#8. create and save text file with all info about products below 50 EUR (<50 EUR)
#9. create and save .json file with all info about products below 50 EUR (<50 EUR)