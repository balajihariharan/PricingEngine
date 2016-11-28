package com.sample.pricing.service;

import com.sample.pricing.PricingCriteria;
import com.sample.pricing.RecommendedPrice;

public interface PricingService {
	
	/**
	 * This method computes best price for a list of Products based on conditions below and returns Recommended price
	 * 
	 *  If Supply is High and Demand is High, Product is sold at same price as chosen price.
	 *	If Supply is Low and Demand is Low, Product is sold at 10 % more than chosen price.
	 *	If Supply is Low and Demand is High, Product is sold at 5 % more than chosen price.
	 *	If Supply is High and Demand is Low, Product is sold at 5 % less than chosen price.
	 * 
	 * @param pricingCriteria
	 * @return RecommendedPrice 
	 */
	public RecommendedPrice findFrequentlyOccuringPrice(PricingCriteria pricingCriteria);

}