package com.coding.sales.metal;

public class MetalInfo {

	/*
	 * 中国银象棋12g 编号：002003 单位：套 价格：698.00 参与满减：每满3000元减350, 每满2000减30，每满1000减10
	 * 可使用9折打折券
	 */
	private String productName;
	private String productNo;
	private String productUnit;
	private Double productPrice;
	private String[] preferentials;
	private String[] discountRates;
	/*
	 * private String preferential; private String discountRate;
	 */
	public MetalInfo(String productName, String productNo, String productUnit, Double productPrice,
			String[] preferentials, String[] discountRates) {
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
	public Double getProductPrice() {
		return productPrice;
	}
	public String[] getPreferentials() {
		return preferentials;
	}
	public String[] getDiscountRates() {
		return discountRates;
	}


}
