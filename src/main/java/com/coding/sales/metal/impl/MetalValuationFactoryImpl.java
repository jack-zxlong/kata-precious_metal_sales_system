package com.coding.sales.metal.impl;

import com.coding.sales.metal.MetalInfo;
import com.coding.sales.metal.inter.MetalValuation;
import com.coding.sales.metal.inter.MetalValuationFactory;

public class MetalValuationFactoryImpl implements MetalValuationFactory {

	@Override
	public MetalValuation makeMetalValuation(MetalInfo mi) {
		// TODO Auto-generated method stub
		if(mi == null) {
			return null;
		}
		
		boolean isHavePreferentials = this.isPreferentials(mi);
		boolean isHaveDiscounts = this.isPreferentials(mi);
		
		if(isHavePreferentials&&!isHaveDiscounts) {
			return new PreferntialValuation(mi);
		}
		if(isHavePreferentials&&isHaveDiscounts) {
			return new ComprehensiveValuation(mi);
		}
		if(!isHavePreferentials&&isHaveDiscounts) {
			
			return new DicountValuation(mi);
		}
		
		return new WithoutPrivilegesorDiscount(mi);
	}
	
	public boolean isPreferentials(MetalInfo mi) {
		
		if(mi.getPreferentials()==null) {
			return false;
		}
		if(mi.getPreferentials().size()>0) {
			return true;
		}
		return false;
	}

	public boolean isDiscount(MetalInfo mi) {
		if(mi.getDiscountRates()==null) {
			return false;
		}
		if(mi.getDiscountRates().length>0) {
			return true;
		}
		return false;
	}
}
