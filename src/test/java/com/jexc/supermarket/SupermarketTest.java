package com.jexc.supermarket;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.jexc.supermarket.Supermarket;
import com.jexc.supermarket.calculator.BasicCalculatorStrategy;
import com.jexc.supermarket.calculator.CalculatorStrategy;
import com.jexc.supermarket.calculator.GroupCalculatorStrategy;

public class SupermarketTest {

	@Test
	public void testOneProduct(){
    	Map<String, CalculatorStrategy> calculatorMap = new HashMap<String, CalculatorStrategy>();
    	calculatorMap.put("A", new BasicCalculatorStrategy(20));

		Supermarket supermarket = new Supermarket(calculatorMap);
		Assert.assertEquals(20, supermarket.checkout("A"));
	}

	@Test
	public void testOneProductThreeItems(){
    	Map<String, CalculatorStrategy> calculatorMap = new HashMap<String, CalculatorStrategy>();
    	calculatorMap.put("A", new BasicCalculatorStrategy(20));

		Supermarket supermarket = new Supermarket(calculatorMap);
		Assert.assertEquals(60, supermarket.checkout("AAA"));
	}

	@Test
	public void testTwoProductsOneItemEach(){
    	Map<String, CalculatorStrategy> calculatorMap = new HashMap<String, CalculatorStrategy>();
    	calculatorMap.put("A", new BasicCalculatorStrategy(20));
    	calculatorMap.put("B", new BasicCalculatorStrategy(50));

		Supermarket supermarket = new Supermarket(calculatorMap);
		Assert.assertEquals(70, supermarket.checkout("BA"));
	}


	@Test
	public void testTwoProductsThreeItemEach(){
    	Map<String, CalculatorStrategy> calculatorMap = new HashMap<String, CalculatorStrategy>();
    	calculatorMap.put("A", new BasicCalculatorStrategy(20));
    	calculatorMap.put("B", new GroupCalculatorStrategy(50, 5, 150));

		Supermarket supermarket = new Supermarket(calculatorMap);
		Assert.assertEquals(210, supermarket.checkout("AABABB"));
	}

	@Test
	public void testThreeProductsOneItemEach(){
    	Map<String, CalculatorStrategy> calculatorMap = new HashMap<String, CalculatorStrategy>();
    	calculatorMap.put("A", new BasicCalculatorStrategy(20));
    	calculatorMap.put("B", new BasicCalculatorStrategy(50));
    	calculatorMap.put("C", new BasicCalculatorStrategy(30));

		Supermarket supermarket = new Supermarket(calculatorMap);
		Assert.assertEquals(100, supermarket.checkout("BAC"));
	}

	@Test
	public void testThreeProductsThreeItemEach(){
    	Map<String, CalculatorStrategy> calculatorMap = new HashMap<String, CalculatorStrategy>();
    	calculatorMap.put("A", new BasicCalculatorStrategy(20));
    	calculatorMap.put("B", new GroupCalculatorStrategy(50, 5, 150));
    	calculatorMap.put("C", new BasicCalculatorStrategy(30));

		Supermarket supermarket = new Supermarket(calculatorMap);
		Assert.assertEquals(300, supermarket.checkout("CCAABABCB"));
	}

	@Test
	public void testExerciseScenario(){
    	Map<String, CalculatorStrategy> calculatorMap = new HashMap<String, CalculatorStrategy>();
    	calculatorMap.put("A", new BasicCalculatorStrategy(20));
    	calculatorMap.put("B", new GroupCalculatorStrategy(50, 5, 150));
    	calculatorMap.put("C", new BasicCalculatorStrategy(30));

		Supermarket supermarket = new Supermarket(calculatorMap);
		Assert.assertEquals(240, supermarket.checkout("ABBACBBAB"));
	}

	@Test
	public void testThreeProductsTwoDiscounts(){
    	Map<String, CalculatorStrategy> calculatorMap = new HashMap<String, CalculatorStrategy>();
    	calculatorMap.put("A", new BasicCalculatorStrategy(20));
    	calculatorMap.put("B", new GroupCalculatorStrategy(50, 5, 150));
    	calculatorMap.put("C", new BasicCalculatorStrategy(30));

		Supermarket supermarket = new Supermarket(calculatorMap);
		Assert.assertEquals(460, supermarket.checkout("BBACBBABABBACBBAB"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMissingCalculatorMapFails(){
		new Supermarket(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyCalculatorMapFails(){
		new Supermarket(new HashMap<String, CalculatorStrategy>());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMissingCalculatorFails(){
    	Map<String, CalculatorStrategy> calculatorMap = new HashMap<String, CalculatorStrategy>();
    	calculatorMap.put("A", new BasicCalculatorStrategy(20));
    	calculatorMap.put("C", new BasicCalculatorStrategy(30));

		Supermarket supermarket = new Supermarket(calculatorMap);
		supermarket.checkout("BBACBBABABBACBBAB");
	}
}
