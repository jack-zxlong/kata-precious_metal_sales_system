package com.coding.sales.metal.impl;

import java.math.BigDecimal;

import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.metal.MetalInfo;
import com.coding.sales.metal.inter.MetalValuation;

public class ComprehensiveValuation  extends MetalValuation{
	private MetalInfo mi;

	public ComprehensiveValuation(MetalInfo mi) {
		super();
		this.mi = mi;
	}

	public MetalInfo getMi() {
		return mi;
	}

	@Override
	public BigDecimal makeMetalPrice(MetalInfo metalinfo,OrderItemCommand orderCommand) {
		// TODO Auto-generated method stub
		return null;
	}
}
