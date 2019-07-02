package com.coding.sales.customer;

public class OrdinaryCustomer extends Customer{

	private int upgradePoints;
	
	public OrdinaryCustomer(String name, String memberId, int points) {
		super(name, memberId, points);
		// TODO Auto-generated constructor stub
		upgradePoints = 10000;
		grade = "普卡";
	}

	@Override
	public void earnedPoints(int amountMoney) {
		// TODO Auto-generated method stub
		points += amountMoney;
		makeSureCustomerShouldUpgrade(upgradePoints);
	}
}
