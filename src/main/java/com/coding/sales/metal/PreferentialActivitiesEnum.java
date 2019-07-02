package com.coding.sales.metal;

public enum PreferentialActivitiesEnum {

	
	WITHOUTPRIVILEGES("0"),WHEN3000MINUS350("1"),WHEN2000MINUS30("2"),WHEN1000MINUS10("3"),PART3HALFPRICE("4"),FULL3TO1("5"),;
	
	private final String value;

	private PreferentialActivitiesEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	public static void main(String[] args) {
		System.out.println(PreferentialActivitiesEnum.FULL3TO1.value);
	}
}
