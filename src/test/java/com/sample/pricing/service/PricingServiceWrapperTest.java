package com.sample.pricing.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import com.sample.pricing.RecommendedPrice;

public class PricingServiceWrapperTest {
	PricingServiceWrapper pricingServiceWrapper = null;
	@Before
	public void setup(){
		pricingServiceWrapper = new  PricingServiceWrapper();
	}
	@Test
	public void testInput1() {
		// These details could come from making a Rest call/DB or as .CSV file
		List<String> productTypes = new ArrayList<String>();
		productTypes.add("flashdrive H H");
		productTypes.add("ssd L H");
		List<String>productList = new ArrayList<String>();
 
		productList.add("flashdrive X 1.0");
		productList.add("ssd X 10.0");
		productList.add("flashdrive Y 0.9");
		productList.add("flashdrive Z 1.1");
		productList.add("ssd Y 12.5");
		List<RecommendedPrice> recommendedPriceList = pricingServiceWrapper.findBestPriceForProducts(productTypes, productList);
		assertThat(recommendedPriceList.size(), equalTo(productTypes.size()));
		assertNotNull("RecommendedPrice List is null ",recommendedPriceList.get(0));
		assertThat(recommendedPriceList.get(0).getRecommendedPrice(),equalTo(0.9));
		assertThat(recommendedPriceList.get(1).getRecommendedPrice(),equalTo(10.5));
	}

}
