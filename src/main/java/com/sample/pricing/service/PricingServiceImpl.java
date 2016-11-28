package com.sample.pricing.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sample.pricing.PricingCriteria;
import com.sample.pricing.Product;
import com.sample.pricing.RecommendedPrice;
import com.sample.pricing.SearchCriteria;
import com.sample.pricing.SearchCriteriaImpl;
import com.sample.pricing.SupplyDemand;

public class PricingServiceImpl implements PricingService {
	private SearchCriteria searchCriteria;
	public PricingServiceImpl(){
		searchCriteria = new SearchCriteriaImpl();
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
	 * @param pricingCriteria
	 * @return RecommendedPrice
	 */
	public RecommendedPrice findFrequentlyOccuringPrice(PricingCriteria pricingCriteria) {

		// check the parameter for demand and supply
		boolean highDemand = pricingCriteria.getDemand().equals(SupplyDemand.H) ? true
				: false;
		boolean highSupply = pricingCriteria.getSupply().equals(SupplyDemand.H) ? true
				: false;
		List<Product> products = pricingCriteria.getProducts();
		//sort the list by price that way lowest priced product is first in the list
		Collections.sort(products, new Comparator<Product>() {
			public int compare(Product o1, Product o2) {
				return o1.getPrice().compareTo(o2.getPrice());
			}
		});

		Product lowerPricedProduct = searchCriteria.calculateLowestPrice(products);
		double recommendedPrice = 0;
		if (highSupply && highDemand) {
			recommendedPrice = lowerPricedProduct.getPrice();
		} else if (!highSupply && !highDemand) {
			String percentageValue =  PropertyManager.getInstance().getValue("lowSupply.lowDemand");
			recommendedPrice = (lowerPricedProduct.getPrice() + lowerPricedProduct
					.getPrice() * Double.parseDouble(percentageValue));
			// sell at more that 10% chosen price
		} else if (!highSupply && highDemand) {
			String percentageValue =  PropertyManager.getInstance().getValue("lowSupply.highDemand");
			recommendedPrice = (lowerPricedProduct.getPrice() + lowerPricedProduct
					.getPrice() * Double.parseDouble(percentageValue));
			// sell more than 5%
		} else if (highSupply && !highDemand) {
			String percentageValue =  PropertyManager.getInstance().getValue("highSupply.lowDemand");
			recommendedPrice = (lowerPricedProduct.getPrice() - lowerPricedProduct
					.getPrice() * Double.parseDouble(percentageValue));
			// sell 5% less
		}
		RecommendedPrice chosenProduct = new RecommendedPrice();
		chosenProduct.setProduct(lowerPricedProduct);
		chosenProduct.setRecommendedPrice(recommendedPrice);
		return chosenProduct;
	}

	

}
