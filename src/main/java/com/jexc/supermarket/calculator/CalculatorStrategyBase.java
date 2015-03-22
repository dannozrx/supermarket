package com.jexc.supermarket.calculator;

/**
 * This abstract class exists to provide the primary attribute to all calculators, item price.
 * 
 * @author danderson
 */
public abstract class CalculatorStrategyBase implements CalculatorStrategy {

	protected int itemPrice = 0;

	/**
	 * Private default constructor. We don't want to allow usage of this constructor at this time.
	 */
    @SuppressWarnings("unused")
	private CalculatorStrategyBase(){
    	this.itemPrice = 0;
    }

	/**
	 * Setup the calculator with the item price.
	 * 
	 * @param itemPrice The individual item price to be applied to each 'ungrouped' item.
	 */
    public CalculatorStrategyBase(int itemPrice){
    	if( itemPrice <= 0 ){
    		throw new IllegalArgumentException("The item price must be greater than zero.");
    	}
    	this.itemPrice = itemPrice;
    }

}
