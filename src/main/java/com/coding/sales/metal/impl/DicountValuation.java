package com.coding.sales.metal.impl;

import java.math.BigDecimal;
import java.util.Arrays;

import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.metal.MetalInfo;
import com.coding.sales.metal.inter.MetalValuation;

public class DicountValuation extends MetalValuation {

	private MetalInfo mi;

	public DicountValuation(MetalInfo mi) {
		super();
		this.mi = mi;
	}

	public MetalInfo getMi() {
		return mi;
	}

	@Override
	public BigDecimal makeMetalPrice(MetalInfo metalinfo,OrderItemCommand orderCommand) {
		// TODO Auto-generated method stub
		
		BigDecimal amount = orderCommand.getAmount();
		BigDecimal price = BigDecimal.valueOf(metalinfo.getProductPrice());
		BigDecimal minDiscount = BigDecimal.valueOf(this.getMinDiscount(metalinfo));
		BigDecimal costAmount = price.multiply(amount).multiply(minDiscount)  ;
	 	return costAmount;
		
	}
	
	public Double getMinDiscount(MetalInfo metalinfo) {
		Double[] ds= metalinfo.getDiscountRates();
		Double min = ds[0];
		for(int i=0;i<ds.length;i++) {
			   if(ds[i]<min){
			       min = ds[i];
			   }
			}
		return min;
	}
	
}
