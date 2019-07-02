package com.coding.sales.metal.impl;

import java.math.BigDecimal;
import java.util.List;

import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.metal.MetalInfo;
import com.coding.sales.metal.PreferentialActivities;
import com.coding.sales.metal.inter.MetalValuation;

public class PreferntialValuation extends MetalValuation {

	private MetalInfo mi;

	public PreferntialValuation(MetalInfo mi) {
		super();
		this.mi = mi;
	}

	public MetalInfo getMi() {
		return mi;
	}

	@Override
	public BigDecimal makeMetalPrice(MetalInfo metalinfo,OrderItemCommand orderCommand) {
		// TODO Auto-generated method stub
		List<PreferentialActivities> preferentials = metalinfo.getPreferentials();
		

			//PreferentialActivities = preferentials.get(index)
		
		
		
		return null;
		
	}
	
	
}
