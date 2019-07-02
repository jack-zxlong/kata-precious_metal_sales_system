package com.coding.sales.customer;

public class PlatinumCustomer extends Customer implements CustomerRating{

	public PlatinumCustomer(String name, String memberId, int points) {
		super(name, memberId, points);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void earnedPoints(int amountMoney) {
		// TODO Auto-generated method stub
		points += amountMoney*1.8;
	}

	@Override
	public void makeSureCustomerShouldUpgrade() {
		// TODO Auto-generated method stub
		if(points >= 100000){
			shouldUpgrade = true;
		}
	}
}
