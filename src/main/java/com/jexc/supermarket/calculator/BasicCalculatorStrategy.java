package com.jexc.supermarket.calculator;

/**
 * The BasicProductCalculator is used to perform a calculation of the item price times the number of items specified.
 * 
 * @author danderson
 */
public class BasicCalculatorStrategy extends CalculatorStrategyBase {
	
	/**
	 * This constructor is used to configure the item price.
	 * 
	 * @param itemPrice The item price
	 */
	public BasicCalculatorStrategy(int itemPrice) {
		super(itemPrice);
	}

	/**
	 * This method will calculate the total cost given the number of items specified and the price per item 
	 * specified when the instance was created. This method will throw an IllegalArgumentException if the 
	 * number of items is 0.
	 * 
	 * @param numberOfItems The number of items to purchase
	 * @return int The total cost to purchase all of the items
	 */
	public int calculateTotalCost(int numberOfItems){
    	if( numberOfItems <= 0 ){
    		throw new IllegalArgumentException("The number of items must be greater than zero.");
    	}

    	// This is just a straight calculation of the price times the number of items.
		return this.itemPrice * numberOfItems;
	}

}
