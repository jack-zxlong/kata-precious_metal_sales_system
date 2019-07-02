package com.coding.sales.customer;

public class Customer {
	public String name;
	public String memberId;
	public int points;

	public Customer(String name, String memberId, int points) {
		super();
		this.name = name;
		this.memberId = memberId;
		this.points = points;
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
}
