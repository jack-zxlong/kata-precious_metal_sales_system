package com.coding.sales.metal;

public class PreferentialActivities {

	private Double limitAmount;
	private Double preferentialAmount;
	private String preferentialMode;
	
	public PreferentialActivities(Double limitAmount, Double preferentialAmount, String preferentialMode) {
		super();
		this.limitAmount = limitAmount;
		this.preferentialAmount = preferentialAmount;
		this.preferentialMode = preferentialMode;
	}
	public Double getLimitAmount() {
		return limitAmount;
	}
	public Double getPreferentialAmount() {
		return preferentialAmount;
	}
	public String getPreferentialMode() {
		return preferentialMode;
	}
	
	
	
}
