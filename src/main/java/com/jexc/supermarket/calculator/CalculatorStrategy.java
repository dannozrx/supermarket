package com.jexc.supermarket.calculator;

/**
 * This interface exists primarily so that new calculator types can be added and used without changing 
 * the Supermarket class.
 * 
 * @author danderson
 */
public interface CalculatorStrategy {
	
	
	/**
	 * Each calculator strategy must implement this method to calculate the total
	 * cost for the number of items specified.
	 * 
	 * @param numberOfItems The number of items to purchase
	 * @return int The total cost of the items
	 */
	public int calculateTotalCost(int numberOfItems);
}
