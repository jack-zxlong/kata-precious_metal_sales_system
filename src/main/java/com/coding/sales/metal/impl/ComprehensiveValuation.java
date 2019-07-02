package com.coding.sales.metal.impl;

import java.math.BigDecimal;
import java.util.List;

import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.metal.MetalInfo;
import com.coding.sales.metal.PreferentialActivities;
import com.coding.sales.metal.PreferentialModeEnum;
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
		
		BigDecimal minCostOfHavePreferentials = this.getMinCostOfHavePreferentials(metalinfo, orderCommand);
		BigDecimal minCostOfHaveDiscount = this.getMinCostOfHavePreferentials(metalinfo, orderCommand);
		if(minCostOfHavePreferentials.compareTo(minCostOfHaveDiscount)>=0) {
			return minCostOfHaveDiscount;
		}
		
		return minCostOfHavePreferentials;
		
	}
	
	public BigDecimal getMinCostOfHavePreferentials(MetalInfo metalinfo,OrderItemCommand orderCommand) {
		
		List<PreferentialActivities> preferentials = metalinfo.getPreferentials();
		BigDecimal unitPrice = metalinfo.getProductPrice();
		BigDecimal counts = orderCommand.getAmount();
		BigDecimal allAmount = unitPrice.multiply(counts);
		
		BigDecimal[] costs = new BigDecimal[preferentials.size()];

		for (int i = 0; i < preferentials.size(); i++) {

			PreferentialActivities ps = preferentials.get(i);
			if (ps.getPreferentialMode().equals(PreferentialModeEnum.TOTALAMOUNTMODE.getValue())) {

				if (allAmount.compareTo(ps.getLimitAmount()) >= 0) {
					costs[i] = allAmount.subtract(ps.getPreferentialAmount());
				}
			}
			if (ps.getPreferentialMode().equals(PreferentialModeEnum.TOTALUNITMODE.getValue())) {

				if (counts.compareTo(ps.getLimitAmount()) >= 0) {
					costs[i] = allAmount.subtract(unitPrice.multiply(ps.getPreferentialAmount()));
				}
			}

		}

		return this.getMinCost(costs);
	}
	
	public BigDecimal getMinCostOfHaveDiscount(MetalInfo metalinfo,OrderItemCommand orderCommand) {
		BigDecimal amount = orderCommand.getAmount();
		BigDecimal price = metalinfo.getProductPrice();
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
	
	public BigDecimal getMinCost(BigDecimal[] costs) {
		BigDecimal min = costs[0];
		for(int i=0;i<costs.length;i++) {
			   if(costs[i].compareTo(min)>0){
			       min = costs[i];
			   }
			}
		return min;
		
	}
}
