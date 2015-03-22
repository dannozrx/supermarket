package com.jexc.supermarket.calculator;

import org.junit.Assert;
import org.junit.Test;

import com.jexc.supermarket.calculator.BasicCalculatorStrategy;

public class BasicCalculatorStrategTest {
	
	@Test
	public void testOneItemPurchased() {
		executePositiveTest(20, 1);
	}

	@Test
	public void testFiveItemsPurchased() {
		executePositiveTest(30, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMissingPriceFails() {
		BasicCalculatorStrategy calculator = new BasicCalculatorStrategy(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMissingItemCountFails() {
		BasicCalculatorStrategy calculator = new BasicCalculatorStrategy(40);
		calculator.calculateTotalCost(0);
	}
	
	private void executePositiveTest(int itemPrice, int numberOfItems ) {
		BasicCalculatorStrategy calculator = new BasicCalculatorStrategy(itemPrice);
		Assert.assertEquals((itemPrice * numberOfItems), calculator.calculateTotalCost(numberOfItems));
	}

}
