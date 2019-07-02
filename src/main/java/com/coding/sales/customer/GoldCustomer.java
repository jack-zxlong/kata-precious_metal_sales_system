package com.coding.sales.customer;

public class GoldCustomer extends Customer{
	private int upgradePoints;

	public GoldCustomer(String name, String memberId, int points) {
		super(name, memberId, points);
		// TODO Auto-generated constructor stub
		upgradePoints = 50000;
		grade = "金卡";
	}

	@Override
	public void earnedPoints(int amountMoney) {
		// TODO Auto-generated method stub
		points += amountMoney*1.5;
		makeSureCustomerShouldUpgrade(upgradePoints);
	}
}
