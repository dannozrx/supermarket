package com.jexc.supermarket;

import java.util.Iterator;
import java.util.Map;

import com.jexc.supermarket.calculator.CalculatorStrategy;
import com.jexc.supermarket.util.ItemCounter;

/**
 * This class can be used to calculate the total cost of purchasing one or more different products, while
 * applying defferent pricing strategies for each product.
 * 
 * @author danderson
 */
public class Supermarket {
	
	private Map<String, CalculatorStrategy> productToCalculatorMap;

	/**
	 * Private default constructor. We don't want to allow usage of this constructor at this time.
	 */
	@SuppressWarnings("unused")
	private Supermarket(){
	}
	
	/**
	 * This constructor must be passed a Map of products to product calculator strategies. 
	 * This mapping must specify a calculator for each product type that will be purchased.
	 * 
	 * @param productCalculatorMap
	 */
	public Supermarket(Map<String, CalculatorStrategy> productToCalculatorMap){
    	if( null == productToCalculatorMap || productToCalculatorMap.size() <= 0 ){
    		throw new IllegalArgumentException("The product to calculator map cannot be null or empty.");
    	}
		this.productToCalculatorMap = productToCalculatorMap;
	}
	
	/**
	 * Calculate the total cost of the items. Each item is represented by a single character in the items argument. 
	 * This method is case sensitive and the list of items should be formulated with that in mind.
	 * 
	 * @param items The list of items
	 * @return The total cost of all items
	 */
	public int checkout(String items){
		int totalCost = 0;
		
		// Determine the number of each item to be purchased
		Map<String, Integer> itemCounts = ItemCounter.gatherItemCounts(items);
		
		// Ensure that there is a calculator strategy specified for each item type
		validateProductsHaveACalculatorStrategy(itemCounts);

		// The product calculator strategies are stored in the map by product type, as are the 
		// number of each product type to purchase. 
		Iterator<String> keyIterator = itemCounts.keySet().iterator();
		// Accumulate the cost of each item to be purchased
		while( keyIterator.hasNext() ){
			String productType = keyIterator.next();
			// Use the product type to retrieve the calculator strategy and the number of items to purchase
			totalCost += productToCalculatorMap.get(productType).calculateTotalCost(itemCounts.get(productType));
		}
		
		return totalCost;
	}

	/**
	 * Ensure that there is a calculator strategy specified for each product which is being purchased. If there  
	 * are any product types that do not have a calculator, we will throw an IllegalArgumentException specifying  
	 * which products do not have a calculator
	 * 
	 * @param items The item
	 */
	private void validateProductsHaveACalculatorStrategy(Map<String, Integer> itemCounts){
		Iterator<String> keyIterator = itemCounts.keySet().iterator();
		String missingTypes = "";
		
		// Loop through each of the product types to be purchased and check to see if a calculator 
		// strategy was provided.
		while( keyIterator.hasNext() ){
			String productType = keyIterator.next();
			CalculatorStrategy calculator = productToCalculatorMap.get(productType);
			if( null == calculator ){
				if( missingTypes.length() > 0 ){
					missingTypes += ", ";
				}
				// Append the missing type to the list to be returned via the IllegalArgumentException
				missingTypes += productType;
			}
		}
		
		if( missingTypes.length() > 0 ){
			throw new IllegalArgumentException("The following type(s) do not have a corresponding calculator strategy: " + missingTypes);
		}
	}
}
