package com.coding.sales.metal;

public enum DiscountEnum {

	WITHOUTDISCOUNT("1"),DISCOUNTRATEOF95("0.95"), DISCOUNTRATEOF90("0.90");

	private final String name;

	private DiscountEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
