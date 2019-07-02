package com.coding.sales.metal;

import java.math.BigDecimal;

public class PreferentialActivities {

	private BigDecimal limitAmount;
	private BigDecimal preferentialAmount;
	private String preferentialMode;
	
	public PreferentialActivities(BigDecimal limitAmount, BigDecimal preferentialAmount, String preferentialMode) {
		super();
		this.limitAmount = limitAmount;
		this.preferentialAmount = preferentialAmount;
		this.preferentialMode = preferentialMode;
	}
	public BigDecimal getLimitAmount() {
		return limitAmount;
	}
	public BigDecimal getPreferentialAmount() {
		return preferentialAmount;
	}
	public String getPreferentialMode() {
		return preferentialMode;
	}
	
	
	
}
