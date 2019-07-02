package com.coding.sales.customer;

import java.math.BigDecimal;

public class GoldCustomer extends Customer{
	private int upgradePoints;

	public GoldCustomer(String name, String memberId, BigDecimal points) {
		super(name, memberId, points);
		// TODO Auto-generated constructor stub
		upgradePoints = 50000;
		grade = "金卡";
	}

	@Override
	public void earnedPoints(BigDecimal amountMoney) {
		// TODO Auto-generated method stub
		points = points.add( amountMoney.multiply(new BigDecimal(1.5)) );
		makeSureCustomerShouldUpgrade(upgradePoints);
	}
}
