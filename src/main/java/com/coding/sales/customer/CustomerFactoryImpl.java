package com.coding.sales.customer;

import java.math.BigDecimal;

public class CustomerFactoryImpl implements CustomerFactory{
	@Override
	public Customer makeCustomer(String name, String cardNumber, BigDecimal points) {
		// TODO Auto-generated method stub
		if(points.compareTo(new BigDecimal(10000)) == -1){
			return new OrdinaryCustomer(name, cardNumber, points);
		}
		else if(points.compareTo(new BigDecimal(50000)) == -1){
			return new GoldCustomer(name, cardNumber, points);
		}
		else if(points.compareTo(new BigDecimal(100000)) == -1){
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
