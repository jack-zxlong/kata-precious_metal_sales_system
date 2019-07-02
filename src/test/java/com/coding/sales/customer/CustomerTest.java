package com.coding.sales.customer;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.internal.matchers.Or;

public class CustomerTest {

	CustomerFactoryImpl impl = new CustomerFactoryImpl();

	Customer customerOrdinary = impl.makeCustomer("马丁", "6236609999", 9860);
	Customer customerGold = impl.makeCustomer("王立", "6630009999", 48860);
	Customer customerPlatinum = impl.makeCustomer("李想", "8230009999", 98860);
	Customer customerDiamond = impl.makeCustomer("张三", "9230009999", 198860);

	@Test
	public void testOrdinaryCustomer() {
		Customer customer = impl.makeCustomer("马丁", "6236609999", 9860);
		assertEquals("普卡", customer.getGrade());
	}
	
	@Test
	public void testGoldCustomer() {
		Customer customer = impl.makeCustomer("王立", "6630009999", 48860);
		assertEquals("金卡", customer.getGrade());
	}

	@Test
	public void testPlatinumCustomer() {
		Customer customer = impl.makeCustomer("李想", "8230009999", 98860);
		assertEquals("白金卡", customer.getGrade());
	}
	
	@Test
	public void testDiamondCustomer() {
		Customer customer = impl.makeCustomer("张三", "9230009999", 198860);
		assertEquals("钻石卡", customer.getGrade());
	}
	
	@Test
	public void testCustomerOrdinaryEarnedPoints(){
		customerOrdinary.earnedPoints(141);
		assertEquals(10001, customerOrdinary.getPoints());
	}

	@Test
	public void testCustomerOrdinaryUpgradeStatus(){
		customerOrdinary.earnedPoints(141);
		assertEquals(true, customerOrdinary.getShouldUpgradeStatus());
	}
	
	@Test
	public void testCustomerOrdinaryUpgrade(){
		customerOrdinary.earnedPoints(141);
		assertEquals(true, customerOrdinary.getShouldUpgradeStatus());
		Customer customerUpgrade = impl.upgradeCustomer(customerOrdinary);
		assertEquals("金卡", customerUpgrade.getGrade());
	}
	
	
	
}
