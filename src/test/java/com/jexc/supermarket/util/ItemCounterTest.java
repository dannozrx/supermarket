package com.jexc.supermarket.util;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.jexc.supermarket.util.ItemCounter;

public class ItemCounterTest {

	@Test
	public void testOneItemFound() {
		Map<String, Integer> collatedList = ItemCounter.gatherItemCounts("A");
		Assert.assertNotNull(collatedList);
		Assert.assertEquals(1, collatedList.size());
		Assert.assertEquals(1, collatedList.get("A").intValue());
	}

	@Test
	public void testThreeSameItemsFound() {
		Map<String, Integer> collatedList = ItemCounter.gatherItemCounts("BBB");
		Assert.assertNotNull(collatedList);
		Assert.assertEquals(1, collatedList.size());
		Assert.assertEquals(3, collatedList.get("B").intValue());
	}

	@Test
	public void testTwoTypesFoundTwoItemsEach() {
		Map<String, Integer> collatedList = ItemCounter.gatherItemCounts("BBCC");
		Assert.assertNotNull(collatedList);
		Assert.assertEquals(2, collatedList.size());
		Assert.assertEquals(2, collatedList.get("B").intValue());
		Assert.assertEquals(2, collatedList.get("C").intValue());
	}

	@Test
	public void testThreeTypesFoundFourItemsEach() {
		Map<String, Integer> collatedList = ItemCounter.gatherItemCounts("ABCAACBBCCBA");
		Assert.assertNotNull(collatedList);
		Assert.assertEquals(3, collatedList.size());
		Assert.assertEquals(4, collatedList.get("A").intValue());
		Assert.assertEquals(4, collatedList.get("B").intValue());
		Assert.assertEquals(4, collatedList.get("C").intValue());
	}

	@Test
	public void testDifferentCaseIsDifferentType() {
		Map<String, Integer> collatedList = ItemCounter.gatherItemCounts("AaAa");
		Assert.assertNotNull(collatedList);
		Assert.assertEquals(2, collatedList.size());
		Assert.assertEquals(2, collatedList.get("A").intValue());
		Assert.assertEquals(2, collatedList.get("a").intValue());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullListFails() {
		ItemCounter.gatherItemCounts(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyListFails() {
		ItemCounter.gatherItemCounts("");
	}
}
