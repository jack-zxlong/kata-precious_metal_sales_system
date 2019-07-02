package com.coding.sales.metal.inter;

import java.math.BigDecimal;

import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.metal.MetalInfo;

public abstract class MetalValuation {
	public abstract BigDecimal makeMetalPrice(MetalInfo metalinfo,OrderItemCommand orderCommand);

}
