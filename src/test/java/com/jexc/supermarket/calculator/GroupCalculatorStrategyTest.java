package com.jexc.supermarket.calculator;

import org.junit.Assert;
import org.junit.Test;

import com.jexc.supermarket.calculator.GroupCalculatorStrategy;

public class GroupCalculatorStrategyTest {
	
	@Test
	public void testOneItemPurchased() {
		GroupCalculatorStrategy calculator = new GroupCalculatorStrategy(50, 5, 150);
		Assert.assertEquals(50, calculator.calculateTotalCost(1));
	}

	@Test
	public void testFiveItemsPurchased() {
		GroupCalculatorStrategy calculator = new GroupCalculatorStrategy(50, 5, 150);
		Assert.assertEquals(150, calculator.calculateTotalCost(5));
	}

	@Test
	public void testSevenItemsPurchased() {
		GroupCalculatorStrategy calculator = new GroupCalculatorStrategy(50, 5, 150);
		Assert.assertEquals(250, calculator.calculateTotalCost(7));
	}

	@Test
	public void testTenItemsPurchased() {
		GroupCalculatorStrategy calculator = new GroupCalculatorStrategy(50, 5, 150);
		Assert.assertEquals(300, calculator.calculateTotalCost(10));
	}
	
	@Test
	public void testTwelveItemsPurchased() {
		GroupCalculatorStrategy calculator = new GroupCalculatorStrategy(50, 5, 150);
		Assert.assertEquals(400, calculator.calculateTotalCost(12));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMissingPriceFails() {
		new GroupCalculatorStrategy(0, 5, 150);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMissingGroupCountFails() {
		new GroupCalculatorStrategy(50, 0, 150);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMissingGroupPriceFails() {
		new GroupCalculatorStrategy(50, 5, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMissingItemCountFails() {
		GroupCalculatorStrategy calculator = new GroupCalculatorStrategy(50, 5, 150);
		calculator.calculateTotalCost(0);
	}
	
}
