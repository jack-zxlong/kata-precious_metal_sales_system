package com.coding.sales.customer;

public class PlatinumCustomer extends Customer{
	private int upgradePoints;

	public PlatinumCustomer(String name, String memberId, int points) {
		super(name, memberId, points);
		// TODO Auto-generated constructor stub
		upgradePoints = 100000;
		grade = "白金卡";
	}

	@Override
	public void earnedPoints(int amountMoney) {
		// TODO Auto-generated method stub
		points += amountMoney*1.8;
		
		makeSureCustomerShouldUpgrade(upgradePoints);
	}
}
