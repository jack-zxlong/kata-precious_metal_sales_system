package com.coding.sales.customer;

public class Customer implements CustomerRating{
	public String name;
	public String memberId;
	public int points;
	public boolean shouldUpgrade;
	public String grade;

	public Customer(String name, String memberId, int points) {
		super();
		this.name = name;
		this.memberId = memberId;
		this.points = points;
		this.shouldUpgrade = false;
		this.grade="";
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
	
	public String getGrade(){
		return grade;
	}

	@Override
	public void earnedPoints(int amountMoney) {
		// TODO Auto-generated method stub
	}

	@Override
	public void makeSureCustomerShouldUpgrade(int upgradePoints) {
		// TODO Auto-generated method stub
		if(points >= upgradePoints){
			shouldUpgrade = true;
		}
	}
}
