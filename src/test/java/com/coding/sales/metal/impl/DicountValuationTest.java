package com.coding.sales.metal.impl;

import static org.junit.Assert.*;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.coding.sales.FileUtils;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.metal.MetalInfo;
import com.coding.sales.metal.PreferentialActivities;
import com.coding.sales.metal.PreferentialModeEnum;

public class DicountValuationTest {

	@Test
	public void testMakeMetalPrice() {
		
		  List<PreferentialActivities> preferentials =  new ArrayList<PreferentialActivities>();
		  PreferentialActivities p1 = new PreferentialActivities(new BigDecimal(3000.00), new BigDecimal(350.00), PreferentialModeEnum.TOTALAMOUNTMODE.getValue());
		  PreferentialActivities p2 = new PreferentialActivities(new BigDecimal(1000.00), new BigDecimal(10.00), PreferentialModeEnum.TOTALAMOUNTMODE.getValue());
		  preferentials.add(p1);
		  preferentials.add(p2);
		  Double[]  discountRates = {0.95,0.9};
		  MetalInfo mi = new MetalInfo("世园会五十国钱币册", "001001", "册", new BigDecimal("980.00"), preferentials, discountRates) ;
		  
		  DicountValuation dv =  new DicountValuation(mi);
		  
		  
		  String absolutePath = getResourceFilePath("sample_command.json");
	      String commandString = FileUtils.readFromFile(absolutePath);

	      OrderCommand command = OrderCommand.from(commandString);

		  Double[] ds = {0.1,0.99};
		  dv.makeMetalPrice(mi, command.getItems().get(0));
		 // assertEquals(, actual);
		 
	}
	private String getResourceFilePath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file.getAbsolutePath();
    }
	/*
	 * @Test public void testDicountValuation() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetMi() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetMinDiscount() { fail("Not yet implemented"); }
	 */

}
