package com.coding.sales.customer;

import java.math.BigDecimal;

public interface CustomerFactory {
	public Customer makeCustomer(String name, String cardNumber, BigDecimal points);
	public Customer upgradeCustomer(Customer customer);
}
