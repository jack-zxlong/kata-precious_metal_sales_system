package com.coding.sales.customer;

public class DiamondCustomer extends Customer{

	public DiamondCustomer(String name, String memberId, int points) {
		super(name, memberId, points);
		// TODO Auto-generated constructor stub
		grade = "钻石卡";
	}

	@Override
	public void earnedPoints(int amountMoney) {
		// TODO Auto-generated method stub
		points += amountMoney*2;
	}
}
