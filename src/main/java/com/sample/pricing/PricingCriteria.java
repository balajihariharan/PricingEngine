package com.sample.pricing;

import java.util.List;

public interface PricingCriteria {
	public Product calculateLowestPrice(List<Product> productList);
	public RecommendedProduct calculateRecommendedPrice(SearchCriteria searchCriteria,Product lowerPricedProduct);
}