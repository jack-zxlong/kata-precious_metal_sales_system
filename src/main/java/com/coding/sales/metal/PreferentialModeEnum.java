package com.coding.sales.metal;

public enum PreferentialModeEnum {

	TOTALAMOUNTMODE("0"), TOTALUNITMODE("1");
	private final String value;

	private PreferentialModeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
