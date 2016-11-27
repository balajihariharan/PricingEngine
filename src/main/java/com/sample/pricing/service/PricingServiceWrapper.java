package com.sample.pricing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sample.pricing.PricingCriteria;
import com.sample.pricing.SupplyDemand;
import com.sample.pricing.Product;
import com.sample.pricing.RecommendedPrice;

public class PricingServiceWrapper {
	private PricingService pricingService;
	public PricingServiceWrapper(){
		pricingService = new PricingServiceImpl();
	}
	/**
	 * 
	 * This is a wrapper method to group input parameters
	 * 
	 * @param numberOfProducts
	 * @param supplyList
	 * @param productList
	 * @return RecommendedPrice list
	 */
	public List<RecommendedPrice> findBestPriceForProducts(List<String> productTypes,List<String> productList){
		PricingCriteria pricingCriteria =null;
		Product product = null;
		String [] temp;
		Map<String,PricingCriteria> productGroup = new HashMap<String,PricingCriteria>();
		for (int i=0;i<productTypes.size();i++) {
			 product = new Product();
			 temp = productTypes.get(i).split(" ");
			 product.setName(temp[0]);
			 pricingCriteria = new PricingCriteria();
			 pricingCriteria.setSupply(SupplyDemand.valueOf(temp[1]));
			 pricingCriteria.setDemand(SupplyDemand.valueOf(temp[2]));	
			 pricingCriteria.setProducts(new ArrayList<Product>());
			 productGroup.put(product.getName(),pricingCriteria);
		}
		for(String productRaw :productList){
			temp = productRaw.split(" ");
			product = new Product();
			product.setName(temp[0]);
			product.setManufacturer(temp[1]);
			product.setPrice(Double.parseDouble(temp[2]));
			pricingCriteria = productGroup.get(product.getName());
			List <Product> products = pricingCriteria.getProducts();
			products.add(product);
			pricingCriteria.setProducts(products);
		}
		
		Set<String> keys = productGroup.keySet();
		List<RecommendedPrice> recommendedPriceList = new ArrayList<RecommendedPrice>();
		for (String key : keys) {
			recommendedPriceList.add(pricingService.findBestPrice(productGroup.get(key)));
		}
		
		return recommendedPriceList;
	}

}
