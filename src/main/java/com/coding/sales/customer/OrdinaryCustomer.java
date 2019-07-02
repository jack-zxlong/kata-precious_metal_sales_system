package com.coding.sales.customer;

public class OrdinaryCustomer extends Customer implements CustomerRating{

	public OrdinaryCustomer(String name, String memberId, int points) {
		super(name, memberId, points);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void earnedPoints(int amountMoney) {
		// TODO Auto-generated method stub
		points += amountMoney;
	}

	@Override
	public void makeSureCustomerShouldUpgrade() {
		// TODO Auto-generated method stub
		if(points >= 10000){
			shouldUpgrade = true;
		}
	}
}
