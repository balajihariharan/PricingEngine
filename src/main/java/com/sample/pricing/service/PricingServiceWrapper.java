package com.sample.pricing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sample.pricing.Product;
import com.sample.pricing.RecommendedProduct;
import com.sample.pricing.SearchCriteria;
import com.sample.pricing.SupplyDemand;

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
	public List<RecommendedProduct> findRecommendedPriceForGroup(List<String> productTypes,List<String> productList){
		SearchCriteria searchCriteria =null;
		Product product = null;
		String [] temp;
		Map<String,SearchCriteria> productGroup = new HashMap<String,SearchCriteria>();
		for (int i=0;i<productTypes.size();i++) {
			 product = new Product();
			 temp = productTypes.get(i).split(" ");
			 product.setName(temp[0]);
			 searchCriteria = new SearchCriteria();
			 searchCriteria.setSupply(SupplyDemand.valueOf(temp[1]));
			 searchCriteria.setDemand(SupplyDemand.valueOf(temp[2]));	
			 searchCriteria.setProductList(new ArrayList<Product>());
			 productGroup.put(product.getName(),searchCriteria);
		}
		for(String productRaw :productList){
			temp = productRaw.split(" ");
			product = new Product();
			product.setName(temp[0]);
			product.setManufacturer(temp[1]);
			product.setPrice(Double.parseDouble(temp[2]));
			searchCriteria = productGroup.get(product.getName());
			List <Product> products = searchCriteria.getProductList();
			products.add(product);
			searchCriteria.setProductList(products);
		}
		
		Set<String> keys = productGroup.keySet();
		List<RecommendedProduct> recommendedPriceList = new ArrayList<RecommendedProduct>();
		for (String key : keys) {
			recommendedPriceList.add(pricingService.findRecommendedPrice(productGroup.get(key)));
		}
		
		return recommendedPriceList;
	}

}
