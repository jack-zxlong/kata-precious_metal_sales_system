package com.coding.sales.customer;

import java.math.BigDecimal;

public class DiamondCustomer extends Customer{

	public DiamondCustomer(String name, String memberId, BigDecimal points) {
		super(name, memberId, points);
		// TODO Auto-generated constructor stub
		grade = "钻石卡";
	}

	@Override
	public void earnedPoints(BigDecimal amountMoney) {
		// TODO Auto-generated method stub
		points = points.add( amountMoney.multiply(new BigDecimal(2)) );
	}
}
