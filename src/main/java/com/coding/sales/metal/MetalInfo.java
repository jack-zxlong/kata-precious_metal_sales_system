package com.coding.sales.metal;

import java.math.BigDecimal;
import java.util.List;

public class MetalInfo {

	/*
	 * 中国银象棋12g 编号：002003 单位：套 价格：698.00 参与满减：每满3000元减350, 每满2000减30，每满1000减10
	 * 可使用9折打折券
	 */
	private String productName;
	private String productNo;
	private String productUnit;
	private BigDecimal productPrice;
	private List<PreferentialActivities> preferentials;
	private Double[] discountRates;
	public MetalInfo(String productName, String productNo, String productUnit, BigDecimal productPrice,
			List<PreferentialActivities> preferentials, Double[] discountRates) {
		super();
		this.productName = productName;
		this.productNo = productNo;
		this.productUnit = productUnit;
		this.productPrice = productPrice;
		this.preferentials = preferentials;
		this.discountRates = discountRates;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductNo() {
		return productNo;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public List<PreferentialActivities> getPreferentials() {
		return preferentials;
	}
	public Double[] getDiscountRates() {
		return discountRates;
	}
	

}
