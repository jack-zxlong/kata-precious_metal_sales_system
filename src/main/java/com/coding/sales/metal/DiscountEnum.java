package com.coding.sales.metal;

public enum DiscountEnum {

	WITHOUTDISCOUNT("1"),DISCOUNTRATEOF95("0.95"), DISCOUNTRATEOF90("0.90");

	private final Double value;

	private DiscountEnum(String value) {
		this.value = Double.valueOf(value);
	}

	public Double getValue() {
		return value;
	}
}
