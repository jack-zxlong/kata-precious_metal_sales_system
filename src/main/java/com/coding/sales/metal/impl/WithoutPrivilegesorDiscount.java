package com.coding.sales.metal.impl;

import com.coding.sales.metal.MetalInfo;
import com.coding.sales.metal.inter.MetalValuation;

public class WithoutPrivilegesorDiscount  extends MetalValuation{
	private MetalInfo mi;

	public WithoutPrivilegesorDiscount(MetalInfo mi) {
		super();
		this.mi = mi;
	}

	public MetalInfo getMi() {
		return mi;
	}

	@Override
	public void makeMetalPrice(MetalInfo metalinfo) {
		// TODO Auto-generated method stub
		
	}
}
