package com.coding.sales.customer;

public interface CustomerFactory {
	public Customer makeCustomer(String name, String cardNumber, int points);
	public Customer upgradeCustomer(Customer customer);
}
