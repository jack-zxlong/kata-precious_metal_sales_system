package com.coding.sales.metal;

public class MetalInfo {
	
	/*中国银象棋12g 
	* 编号：002003
	* 单位：套
	* 价格：698.00
	* 参与满减：每满3000元减350, 每满2000减30，每满1000减10
	* 可使用9折打折券*/
	private String productName;
	private String productNo;
	private String productUnit;
	private String productPrice;
	private String preferential;
	private String discountRate;
	
	public MetalInfo(String productName, String productNo, String productUnit, String productPrice, String preferential,
			String discountRate) {
		super();
		this.productName = productName;
		this.productNo = productNo;
		this.productUnit = productUnit;
		this.productPrice = productPrice;
		this.preferential = preferential;
		this.discountRate = discountRate;
	}
	
	
	

}
