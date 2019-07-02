package com.coding.sales.customer;

public class CustomerFactoryImpl implements CustomerFactory{
	@Override
	public Customer makeCustomer(String name, String cardNumber, int points) {
		// TODO Auto-generated method stub
		if(points < 10000){
			return new OrdinaryCustomer(name, cardNumber, points);
		}
		else if(points < 50000){
			return new GoldCustomer(name, cardNumber, points);
		}
		else if(points < 100000){
			return new PlatinumCustomer(name, cardNumber, points);
		}
		else{
			return new DiamondCustomer(name, cardNumber, points);
		}
	}

	@Override
	public Customer upgradeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return makeCustomer(customer.getName(), customer.getMemberId(), customer.getPoints());
	}

}
