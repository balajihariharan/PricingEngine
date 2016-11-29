package com.sample.pricing.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.sample.pricing.RecommendedProduct;
import com.sample.pricing.SearchCriteria;
import com.sample.pricing.SupplyDemand;
import com.sample.pricing.Product;
import com.sample.pricing.service.PricingService;
import com.sample.pricing.service.PricingServiceImpl;

public class PricingServiceImplTest {
	private PricingService pricingService;
	@Before
	public void setup(){
		pricingService = new PricingServiceImpl();
		
	}
	@Test
	public void testSupplyHighDemandHigh() {
		SearchCriteria pricingCriteria = new SearchCriteria();
		pricingCriteria.setDemand(SupplyDemand.H);
		pricingCriteria.setSupply(SupplyDemand.H);
		Product productX = new Product();
		productX.setId("123");
		productX.setManufacturer("X");
		productX.setName("Flashdrive");
		productX.setPrice(1.0);
		Product productY = new Product();
		productY.setId("123");
		productY.setManufacturer("Y");
		productY.setName("Flashdrive");
		productY.setPrice(.9);
		Product productZ = new Product();
		productZ.setId("123");
		productZ.setManufacturer("Z");
		productZ.setName("Flashdrive");
		productZ.setPrice(1.1);
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(productX);
		productList.add(productY);
		productList.add(productZ);
		pricingCriteria.setProductList(productList);
 
		RecommendedProduct recommendedProduct = pricingService.findRecommendedPrice(pricingCriteria);
		assertThat(recommendedProduct.getRecommendedPrice(),equalTo(.9));
		
	}
	@Test
	public void testSupplyLowDemandHigh() {
		SearchCriteria pricingCriteria = new SearchCriteria();
		pricingCriteria.setSupply(SupplyDemand.L);
		pricingCriteria.setDemand(SupplyDemand.H);
		Product productX = new Product();
		productX.setId("1");
		productX.setManufacturer("X");
		productX.setName("SSD");
		productX.setPrice(10.0);
		Product productY = new Product();
		productY.setId("2");
		productY.setManufacturer("Y");
		productY.setName("SSD");
		productY.setPrice(12.5);
		 
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(productX);
		productList.add(productY);
		pricingCriteria.setProductList(productList);
 
		RecommendedProduct recommendedProduct = pricingService.findRecommendedPrice(pricingCriteria);
		assertThat(recommendedProduct.getRecommendedPrice(),equalTo(10.5));
		
	}
	@Test
	public void testSupplyLowDemandLow() {
		SearchCriteria pricingCriteria = new SearchCriteria();
		pricingCriteria.setSupply(SupplyDemand.L);
		pricingCriteria.setDemand(SupplyDemand.L);
		Product productW = new Product();
		productW.setId("1");
		productW.setManufacturer("V");
		productW.setName("SSD");
		productW.setPrice(11.0);
		Product productX = new Product();
		productX.setId("2");
		productX.setManufacturer("V");
		productX.setName("SSD");
		productX.setPrice(12.0);
		Product productV = new Product();
		productV.setId("3");
		productV.setManufacturer("V");
		productV.setName("SSD");
		productV.setPrice(10.0);
		Product productY = new Product();
		productY.setId("4");
		productY.setManufacturer("Y");
		productY.setName("SSD");
		productY.setPrice(11.0);
		Product productZ = new Product();
		productZ.setId("5");
		productZ.setManufacturer("X");
		productZ.setName("SSD");
		productZ.setPrice(12.0);
		 
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(productW);
		productList.add(productX);
		productList.add(productV);
		productList.add(productY);
		productList.add(productZ);
		
		pricingCriteria.setProductList(productList);
 
		RecommendedProduct recommendedProduct = pricingService.findRecommendedPrice(pricingCriteria);
		assertThat(recommendedProduct.getRecommendedPrice(),equalTo(12.1));
		
	}
	@Test
	public void testSupplyHighDemandHigh2() {
		SearchCriteria pricingCriteria = new SearchCriteria();
		pricingCriteria.setDemand(SupplyDemand.H);
		pricingCriteria.setSupply(SupplyDemand.H);
		Product productX = new Product();
		productX.setId("1");
		productX.setManufacturer("X");
		productX.setName("mp3player");
		productX.setPrice(60.0);
		Product productY = new Product();
		productY.setId("2");
		productY.setManufacturer("Y");
		productY.setName("mp3player");
		productY.setPrice(20.0);
		Product productZ = new Product();
		productZ.setId("3");
		productZ.setManufacturer("Z");
		productZ.setName("mp3player");
		productZ.setPrice(50.0);
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(productX);
		productList.add(productY);
		productList.add(productZ);
		pricingCriteria.setProductList(productList);
 
		RecommendedProduct recommendedProduct = pricingService.findRecommendedPrice(pricingCriteria);
		assertThat(recommendedProduct.getRecommendedPrice(),equalTo(50.0));
		
	}
	@Test
	public void testSupplyHighDemandLow() {
		SearchCriteria pricingCriteria = new SearchCriteria();
		pricingCriteria.setDemand(SupplyDemand.L);
		pricingCriteria.setSupply(SupplyDemand.H);
		Product productX = new Product();
		productX.setId("1");
		productX.setManufacturer("X");
		productX.setName("mp3player");
		productX.setPrice(60.0);
		Product productY = new Product();
		productY.setId("2");
		productY.setManufacturer("Y");
		productY.setName("mp3player");
		productY.setPrice(20.0);
		Product productZ = new Product();
		productZ.setId("3");
		productZ.setManufacturer("Z");
		productZ.setName("mp3player");
		productZ.setPrice(50.0);
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(productX);
		productList.add(productY);
		productList.add(productZ);
		pricingCriteria.setProductList(productList);
 
		RecommendedProduct recommendedProduct = pricingService.findRecommendedPrice(pricingCriteria);
		assertThat(recommendedProduct.getRecommendedPrice(),equalTo(47.5));
		
	}
	@Test
	public void testDataError() {
		SearchCriteria pricingCriteria = new SearchCriteria();
		pricingCriteria.setDemand(SupplyDemand.L);
		pricingCriteria.setSupply(SupplyDemand.H);
		Product productX = new Product();
		productX.setId("1");
		productX.setManufacturer("X");
		productX.setName("mp3player");
		productX.setPrice(60.0);
		Product productY = new Product();
		productY.setId("2");
		productY.setManufacturer("Y");
		productY.setName("mp3player");
		productY.setPrice(20.0);
		Product productZ = new Product();
		productZ.setId("3");
		productZ.setManufacturer("Z");
		productZ.setName("mp3player");
		productZ.setPrice(50.0);
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(productX);
		productList.add(productY);
		productList.add(productZ);
		pricingCriteria.setProductList(productList);
 
		RecommendedProduct recommendedProduct = pricingService.findRecommendedPrice(pricingCriteria);
		assertThat(recommendedProduct.getRecommendedPrice(),equalTo(47.5));
		
	}
}
