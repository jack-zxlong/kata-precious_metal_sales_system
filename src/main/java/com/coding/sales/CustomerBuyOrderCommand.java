package com.coding.sales;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.coding.sales.customer.Customer;
import com.coding.sales.customer.CustomerFactoryImpl;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.metal.MetalInfo;
import com.coding.sales.metal.impl.MetalValuationFactoryImpl;
import com.coding.sales.metal.inter.MetalValuation;
import com.coding.sales.output.OrderRepresentation;

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
	
	private void replaseCustomer(Customer customer){
		for(int i=0; i<customerList.size(); i++){
			if(customerList.get(i).getMemberId().equals(customer.getMemberId())){
				customerList.remove(i);
				customerList.add(customer);
			}
		}
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
	
	public OrderRepresentation buyMetal(){
		OrderItemCommand orderItem = orderCommand.getItems().get(0);
	    Customer customer = findCustomer(orderCommand.getMemberId());

	    MetalValuation metalValuation = metalImpl.makeMetalValuation(metalInfoList.get(0));
	    BigDecimal amount = metalValuation.makeMetalPrice(metalInfoList.get(0), orderItem);
	    System.out.println("amount---->"+amount);
	    customer.earnedPoints(amount);
	    
	    Customer  newcustomer = null; 
	    if(customer.getShouldUpgradeStatus()){
	    	newcustomer=impl.upgradeCustomer(customer);
	    	replaseCustomer(newcustomer);
	    }
		
		/*
		 * return new OrderRepresentation(orderCommand.getOrderId(),
		 * orderCommand.getCreateTime(), orderCommand.getMemberId(), customer.getName(),
		 * customer.getGrade(), newcustomer.getGrade(),
		 * (newcustomer.getPoints().subtract(customer.getPoints())).intValue(),
		 * newcustomer.getPoints().intValue(), orderCommand.getItems(), amount, null ,
		 * 0, amount, orderCommand.getPayments(), orderCommand.getDiscounts());
		 */
	    SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
	    Date createTime = sf.parse(orderCommand.getCreateTime());
	    return new OrderRepresentation(orderCommand.getOrderId(), createTime, 
	    		orderCommand.getMemberId(), 
	    		customer.getName(), customer.getGrade(), newcustomer.getGrade(),
	    		(newcustomer.getPoints().subtract(customer.getPoints())).intValue(), newcustomer.getPoints().intValue(), 
	    		orderCommand.getItems(), amount,  null , 0, amount, orderCommand.getPayments(), orderCommand.getDiscounts());
	}
	
}
