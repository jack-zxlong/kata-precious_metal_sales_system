package com.coding.sales.customer;

import java.math.BigDecimal;

public interface CustomerRating {
	public void earnedPoints(BigDecimal amountMoney);
	public void makeSureCustomerShouldUpgrade(int upgradePoints);
}
