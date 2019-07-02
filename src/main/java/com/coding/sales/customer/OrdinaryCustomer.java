package com.coding.sales.customer;

import java.math.BigDecimal;

public class OrdinaryCustomer extends Customer{

	private int upgradePoints;
	
	public OrdinaryCustomer(String name, String memberId, BigDecimal points) {
		super(name, memberId, points);
		// TODO Auto-generated constructor stub
		upgradePoints = 10000;
		grade = "普卡";
	}

	@Override
	public void earnedPoints(BigDecimal amountMoney) {
		// TODO Auto-generated method stub
		points = points.add( amountMoney );
		makeSureCustomerShouldUpgrade(upgradePoints);
	}
}
