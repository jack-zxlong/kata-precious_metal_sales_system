package com.coding.sales.customer;

import java.math.BigDecimal;

public class Customer implements CustomerRating{
	public String name;
	public String memberId;
	public BigDecimal points;
	public boolean shouldUpgrade;
	public String grade;

	public Customer(String name, String memberId, BigDecimal points) {
		super();
		this.name = name;
		this.memberId = memberId;
		this.points = points;
		this.shouldUpgrade = false;
		this.grade="";
	}

	public BigDecimal getPoints() {
		return points;
	}
	
	public String getName(){
		return name;
	}
	
	public String getMemberId(){
		return memberId;
	}
	
	public boolean getShouldUpgradeStatus(){
		return shouldUpgrade;
	}
	
	public String getGrade(){
		return grade;
	}

	@Override
	public void earnedPoints(BigDecimal amountMoney) {
		// TODO Auto-generated method stub
	}

	@Override
	public void makeSureCustomerShouldUpgrade(int upgradePoints) {
		// TODO Auto-generated method stub
		if(points.compareTo(new BigDecimal(upgradePoints)) == 1){
			shouldUpgrade = true;
		}
	}
}
