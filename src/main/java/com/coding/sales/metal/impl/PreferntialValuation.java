package com.coding.sales.metal.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.jar.Pack200.Unpacker;

import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.metal.MetalInfo;
import com.coding.sales.metal.PreferentialActivities;
import com.coding.sales.metal.PreferentialModeEnum;
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
	public BigDecimal makeMetalPrice(MetalInfo metalinfo, OrderItemCommand orderCommand) {
		// TODO Auto-generated method stub
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
