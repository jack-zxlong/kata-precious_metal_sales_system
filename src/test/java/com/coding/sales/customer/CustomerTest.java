package com.coding.sales.customer;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.mockito.internal.matchers.Or;

public class CustomerTest {

	CustomerFactoryImpl impl = new CustomerFactoryImpl();

	Customer customerOrdinary = impl.makeCustomer("马丁", "6236609999", new BigDecimal(9860));
	Customer customerGold = impl.makeCustomer("王立", "6630009999", new BigDecimal(48860));
	Customer customerPlatinum = impl.makeCustomer("李想", "8230009999", new BigDecimal(98860));
	Customer customerDiamond = impl.makeCustomer("张三", "9230009999", new BigDecimal(198860));

	@Test
	public void testOrdinaryCustomer() {
		assertEquals("普卡", customerOrdinary.getGrade());
	}
	
	@Test
	public void testGoldCustomer() {
		assertEquals("金卡", customerGold.getGrade());
	}

	@Test
	public void testPlatinumCustomer() {
		assertEquals("白金卡", customerPlatinum.getGrade());
	}
	
	@Test
	public void testDiamondCustomer() {
		assertEquals("钻石卡", customerDiamond.getGrade());
	}
	
	@Test
	public void testCustomerOrdinaryEarnedPoints(){
		BigDecimal a = new BigDecimal(141);
		customerOrdinary.earnedPoints(a);
//		assertEquals(10001, customerOrdinary.getPoints());
		assertEquals(0, new BigDecimal(10001).compareTo(customerOrdinary.getPoints()));
	}

	@Test
	public void testCustomerOrdinaryUpgradeStatus(){
		BigDecimal a = new BigDecimal(141);
		customerOrdinary.earnedPoints(a);
		assertEquals(true, customerOrdinary.getShouldUpgradeStatus());
	}
	
	@Test
	public void testCustomerOrdinaryUpgrade(){
		BigDecimal a = new BigDecimal(141);
		customerOrdinary.earnedPoints(a);
		assertEquals(true, customerOrdinary.getShouldUpgradeStatus());
		Customer customerUpgrade = impl.upgradeCustomer(customerOrdinary);
		assertEquals("金卡", customerUpgrade.getGrade());
	}
	
	@Test
	public void testCustomerGoldEarnedPoints(){
		BigDecimal a = new BigDecimal(10);
		customerGold.earnedPoints(a);
		//assertEquals(new BigDecimal(48875), customerGold.getPoints());
		assertEquals(0, new BigDecimal(48875).compareTo(customerGold.getPoints()));
	}
	
	@Test
	public void testCustomerPlatinumEarnedPoints(){
		Customer customerPlatinumTemp = impl.makeCustomer("李想", "8230009999", new BigDecimal(98860));
		BigDecimal a = new BigDecimal(10);
		customerPlatinumTemp.earnedPoints(a);
//		assertEquals(new BigDecimal(98878), customerPlatinum.getPoints());
		assertEquals(0, new BigDecimal(98878).compareTo(customerPlatinumTemp.getPoints()));
	}
	
	@Test
	public void testCustomerPlatinumEarnedPoints1000(){
		Customer customerPlatinumTemp = impl.makeCustomer("李想", "8230009999", new BigDecimal(98860));
		BigDecimal a1000 = new BigDecimal(1000);
		customerPlatinumTemp.earnedPoints(a1000);
		assertEquals(0, new BigDecimal(98860 + 1800).compareTo(customerPlatinumTemp.getPoints()));
	}
	
}
