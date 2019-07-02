package com.coding.sales.customer;

public class DiamondCustomer extends Customer implements CustomerRating{

	public DiamondCustomer(String name, String memberId, int points) {
		super(name, memberId, points);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void earnedPoints(int amountMoney) {
		// TODO Auto-generated method stub
		points += amountMoney*2;
	}
}
