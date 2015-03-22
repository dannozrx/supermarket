package com.jexc.supermarket.util;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a utility class that provides static methods for use in counting items.
 * 
 * @author danderson
 */
public class ItemCounter {
	
	/**
	 * This method provides the ability to parse a String of single character items and return a map containing the item
	 * type and the number of items found. This method is case sensitive, so 'A' is a different type than 'a'. This method
	 * will throw an IllegalArgumentException if the items list is empty
	 * 
	 * @param items The single character list of items
	 * @return A map of items and the total count of that item type
	 */
	public static Map<String, Integer> gatherItemCounts(String items){
		Map<String, Integer> collatedList = new HashMap<String, Integer>();
		
		// Nothing to count, let's inform someone.
		if( null == items || items.isEmpty() ){
			throw new IllegalArgumentException("The item list cannot be null or empty.");
		}

		// Convert it to a char array
		char[] itemArray = items.toCharArray();
		
		// Spin through the list and gather the count for each type
		for( char item : itemArray ){
			String itemStr = new Character(item).toString();
			Integer count = collatedList.get(itemStr);
			
			// Ensure that we have something to increment
			if( null == count ){
				count = 0;
			}
			
			count++;
			// Make sure we put the count into the map to ensure that it is incremented properly
			collatedList.put(itemStr, count);
		}
		
		return collatedList;
	}
}
