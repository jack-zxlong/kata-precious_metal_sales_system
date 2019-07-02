package com.coding.sales;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.coding.sales.customer.Customer;
import com.coding.sales.customer.CustomerFactoryImpl;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.metal.MetalInfo;
import com.coding.sales.metal.impl.MetalValuationFactoryImpl;
import com.coding.sales.metal.inter.MetalValuation;

public class CustomerBuyOrderCommand {
	private OrderCommand  orderCommand;
	private List<Customer> customerList = new ArrayList<Customer>();
	private List<MetalInfo> metalInfoList = new ArrayList<MetalInfo>();
	CustomerFactoryImpl impl = new CustomerFactoryImpl();
	MetalValuationFactoryImpl metalImpl = new MetalValuationFactoryImpl();
	
	public CustomerBuyOrderCommand(OrderCommand orderCommand) {
		super();
		this.orderCommand = orderCommand;
		initCustomer();
		initMetalInfo();
	}
	
	private void initCustomer(){
		Customer customerOrdinary = impl.makeCustomer("马丁", "6236609999", new BigDecimal(9860));
		customerList.add(customerOrdinary);
		Customer customerGold = impl.makeCustomer("王立", "6630009999", new BigDecimal(48860));
		customerList.add(customerGold);
		Customer customerPlatinum = impl.makeCustomer("李想", "8230009999", new BigDecimal(98860));
		customerList.add(customerPlatinum);
		Customer customerDiamond = impl.makeCustomer("张三", "9230009999", new BigDecimal(198860));
		customerList.add(customerDiamond);
	}
	
	private Customer findCustomer(String memberId){
		for(int i=0; i<customerList.size(); i++){
			if(customerList.get(i).getMemberId().equals(memberId)){
				return customerList.get(i);
			}
		}

		return null;
	}
	
	public void initMetalInfo(){
		MetalInfo tempMetalInfo001001 = new MetalInfo(
				"世园会五十国钱币册", "001001", "册", new BigDecimal(998.00), null, null);
		metalInfoList.add(tempMetalInfo001001);


		Double[] dis001002 = {0.90};
		MetalInfo tempMetalInfo001002 = new MetalInfo(
				"2019北京世园会纪念银章大全40g", "001002", "盒", new BigDecimal(1380.00), null, dis001002);
		metalInfoList.add(tempMetalInfo001002);
		
		
		MetalInfo tempMetalInfo002002 = new MetalInfo(
				"中国经典钱币套装", "002002", "套", new BigDecimal(998.00), null, null);
		metalInfoList.add(tempMetalInfo002002);
		
		MetalInfo tempMetalInfo002003 = new MetalInfo(
				"中国银象棋12g", "002003", "套", new BigDecimal(698.00), null, null);
		metalInfoList.add(tempMetalInfo002003);
		
	}
	
	public void buyMetal(){
		OrderItemCommand orderItem = orderCommand.getItems().get(0);

	    MetalValuation metalValuation = metalImpl.makeMetalValuation(metalInfoList.get(0));
	    BigDecimal amount = metalValuation.makeMetalPrice(metalInfoList.get(0), orderItem);
	    Customer customer = findCustomer(orderCommand.getMemberId());
	    customer.earnedPoints(amount);
	    if(customer.getShouldUpgradeStatus()){
	    	impl.upgradeCustomer(customer);
	    }
		
	}
	
}
