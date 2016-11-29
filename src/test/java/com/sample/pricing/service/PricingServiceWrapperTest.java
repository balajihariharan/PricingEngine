package com.sample.pricing.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sample.pricing.RecommendedProduct;

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
		List<RecommendedProduct> recommendedPriceList = pricingServiceWrapper.findRecommendedPriceForGroup(productTypes, productList);
		assertThat(recommendedPriceList.size(), equalTo(productTypes.size()));
		assertNotNull("RecommendedPrice List is null ",recommendedPriceList.get(0));
		assertThat(recommendedPriceList.get(0).getRecommendedPrice(),equalTo(0.9));
		assertThat(recommendedPriceList.get(1).getRecommendedPrice(),equalTo(10.5));
	}
	@Test
	public void testInput2() {
		// These details could come from making a Rest call/DB or as .CSV file
		List<String> productTypes = new ArrayList<String>();
		productTypes.add("mp3player H H");
		productTypes.add("ssd L L");
		List<String>productList = new ArrayList<String>();
 
		productList.add("ssd W 11.0");
		productList.add("ssd X 12.0");
		productList.add("mp3player X 60.0");
		productList.add("mp3player Y 20.0");
		productList.add("mp3player Z 50.0");
		productList.add("ssd V 10.0");
		productList.add("ssd Y 11.0");
		productList.add("ssd Z 12.0");
		List<RecommendedProduct> recommendedPriceList = pricingServiceWrapper.findRecommendedPriceForGroup(productTypes, productList);
		assertThat(recommendedPriceList.size(), equalTo(productTypes.size()));
		assertNotNull("RecommendedPrice List is null ",recommendedPriceList.get(0));
		assertThat(recommendedPriceList.get(0).getRecommendedPrice(),equalTo(50.0));
		assertThat(recommendedPriceList.get(1).getRecommendedPrice(),equalTo(12.1));
	}
}
