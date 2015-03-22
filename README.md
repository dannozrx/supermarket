# supermarket
Supermarket Java Exercise

This is a simple supermarket exercise. It has been designed so that the cost of any number of products can be determined by instantiating the proper 
calculator for the product type. Each product type is a single character (case sensitive).

The SupermarketApp, in main/java/com/jexc/supermarket is an executable that is an example of how the Supermarket class is instantiated and used.

## Build ##
To build the jar from the project root use the command:
mvn clean compile package.

To generate the project javadoc from the project root use the command: mvn javadoc:javadoc.

## Execution ##
To run the preconfigured exercise from the project root for the product list of "ABBACBBAB", use the command: java -jar target/supermarket.jar

## Calculator Strategies ##
The Supermarket class must be provided with a Map of the product type (single character, case sensitive) to CalculatorStrategy instance.

This project contains two different calculator strategies that are currently implemented:

### BasicCalculatorStrategy ###
   
   This calculator strategy performs a straight forward computation of the item price times the number of items specified.
 
### GroupCalculatorStrategy ###

   This calculator strategy performs it's computation by first determining how many groups exist, per the specified group count. It then calculates the remaining number of items that do not qualify for the group purchase. The group count is multiplied by the group cost that was specified and the remainder count is multiplied by the individual item price that was specified. The two sums are added together to determine total cost.

### Other Calculator Strategies ###

   New types of calculator strategies may be easily defined and used by implementing the CalculatorStrategy interface. Any new calculator strategies may extend the abstract CalculatorStrategyBase if they wish to do so, but there is no requirement to do so.
   
