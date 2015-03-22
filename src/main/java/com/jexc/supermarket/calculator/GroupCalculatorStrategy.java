package com.jexc.supermarket.calculator;

/**
 * This GroupCalculatorStrategy will calculate the total cost of the number of items. It is designed to apply 
 * a specific cost (The groupPrice constructor argument) for each group of n items (The groupCount constructor 
 * argument). The cost of any extra items will be calculate using the individual rate (The itemPrice constructor 
 * argument).  
 * 
 * @author danderson
 */
public class GroupCalculatorStrategy extends CalculatorStrategyBase {
	
	protected int groupCount = 0; 
	protected int groupPrice = 0;
	
	/**
	 * Setup the calculator with the item price, group size, and group cost.
	 * 
	 * @param itemPrice The individual item price to be applied to each 'ungrouped' item.
	 * @param groupCount The number of items that must be purchased to apply the group price.
	 * @param groupCost The group price amount
	 * 
	 * @see CalculatorStrategyBase#ProductCalculator(int)
	 */
	public GroupCalculatorStrategy(int itemPrice, int groupCount, int groupCost){
		super(itemPrice);
		
    	if( groupCount <= 0 ){
    		throw new IllegalArgumentException("The group count must be greater than zero.");
    	}
    	
    	if( groupCost <= 0 ){
    		throw new IllegalArgumentException("The group cost must be greater than zero.");
    	}

    	this.groupCount = groupCount;
		this.groupPrice = groupCost;
	}
	
	/**
	 * This method will calculate the total cost of purchasing the number of items specified. It will 
	 * determine how many groups exist per the specified group count. Then it will determine the remaining
	 * items. It will then calculate the total cost as the number of groups * the group cost + the remaining
	 * items * the item price. It will throw an IllegalArgumentException if the number of items is 0.
	 * 
	 * @param numberOfItems The number of items to purchase
	 * @return int The total cost of the items
	 */
	public int calculateTotalCost(int numberOfItems) {
		int totalCost = 0;
		
		// This should never be invoked if the number of items is 0.
    	if( numberOfItems <= 0 ){
    		throw new IllegalArgumentException("The number of items must be greater than zero.");
    	}
		
    	// Determine the number of groups
		int numberOfGroups = (int)(numberOfItems / groupCount);
		// Determine the number of remaining items
		int remainingItems = numberOfItems - (numberOfGroups * groupCount);

		// Calculate the total cost
		totalCost = (remainingItems * itemPrice) + (numberOfGroups * groupPrice);
		
		return totalCost;
	}

}
