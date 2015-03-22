package com.jexc.supermarket;

import java.util.HashMap;
import java.util.Map;

import com.jexc.supermarket.calculator.BasicCalculatorStrategy;
import com.jexc.supermarket.calculator.CalculatorStrategy;
import com.jexc.supermarket.calculator.GroupCalculatorStrategy;

/**
 * This class is provided as an example of how to instantiate a Supermarket instance and execute it.
 *  
 * @author danderson
 */
public class SupermarketApp 
{
    public static void main( String[] args )
    {
    	// Create the product to Calculator mapping
    	Map<String, CalculatorStrategy> productToCalculatorMap = new HashMap<String, CalculatorStrategy>();
    	productToCalculatorMap.put("A", new BasicCalculatorStrategy(20));
    	productToCalculatorMap.put("B", new GroupCalculatorStrategy(50, 5, 150));
    	productToCalculatorMap.put("C", new BasicCalculatorStrategy(30));
    	
    	// Create the supermarket instance
        Supermarket supermarket = new Supermarket(productToCalculatorMap);
        
        // Show the total
        System.out.println("The total cost is = " + supermarket.checkout("ABBACBBAB"));
    }
}
