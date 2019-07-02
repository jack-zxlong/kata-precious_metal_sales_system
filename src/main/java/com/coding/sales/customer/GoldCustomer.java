package com.coding.sales.customer;

public class GoldCustomer extends Customer implements CustomerRating{

	public GoldCustomer(String name, String memberId, int points) {
		super(name, memberId, points);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void earnedPoints(int amountMoney) {
		// TODO Auto-generated method stub
		points += amountMoney*1.5;
	}

}
