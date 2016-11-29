package com.sample.pricing.service;

import com.sample.pricing.PricingCriteria;
import com.sample.pricing.PricingCriteriaImpl;
import com.sample.pricing.Product;
import com.sample.pricing.RecommendedProduct;
import com.sample.pricing.SearchCriteria;

public class PricingServiceImpl implements PricingService {
	private PricingCriteria pricingCriteria;
	public PricingServiceImpl(){
		pricingCriteria = new PricingCriteriaImpl();
	}
	/**
	 * This method computes best price for a list of Products based on
	 * conditions below and returns Recommended price
	 * 
	 * If Supply is High and Demand is High, Product is sold at same price as
	 * chosen price. If Supply is Low and Demand is Low, Product is sold at 10 %
	 * more than chosen price. If Supply is Low and Demand is High, Product is
	 * sold at 5 % more than chosen price. If Supply is High and Demand is Low,
	 * Product is sold at 5 % less than chosen price.
	 * 
	 * @param searchCriteria
	 * @return RecommendedPrice
	 */
	public RecommendedProduct findRecommendedPrice(SearchCriteria  searchCriteria) {
		Product lowerPricedProduct = pricingCriteria.calculateLowestPrice(searchCriteria.getProductList());
		return pricingCriteria.calculateRecommendedPrice(searchCriteria, lowerPricedProduct);
	}

	

}
