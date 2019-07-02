package com.coding.sales.customer;

public class Customer {
	public String name;
	public String memberId;
	public int points;
	public boolean shouldUpgrade;

	public Customer(String name, String memberId, int points) {
		super();
		this.name = name;
		this.memberId = memberId;
		this.points = points;
		this.shouldUpgrade = false;
	}

	public int getPoints() {
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
}
