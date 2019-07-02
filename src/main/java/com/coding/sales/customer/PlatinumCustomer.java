package com.coding.sales.customer;

import java.math.BigDecimal;

public class PlatinumCustomer extends Customer{
	private int upgradePoints;

	public PlatinumCustomer(String name, String memberId, BigDecimal points) {
		super(name, memberId, points);
		// TODO Auto-generated constructor stub
		upgradePoints = 100000;
		grade = "白金卡";
	}

	@Override
	public void earnedPoints(BigDecimal amountMoney) {
		// TODO Auto-generated method stub
		points = points.add( amountMoney.multiply(new BigDecimal(1.8)) );
		System.out.println(points.toString());
		makeSureCustomerShouldUpgrade(upgradePoints);
	}
}
