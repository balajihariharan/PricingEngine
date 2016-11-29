package com.sample.pricing;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;

import com.sample.pricing.service.PropertyManager;

public class PricingCriteriaImpl implements PricingCriteria {
	/**
	 * This method computes lower priced product if the price is greater than half of average price
	 * 
	 * @param List of Products
	 * @return a product
	 */
	public Product calculateLowestPrice(List<Product> productList) {
		//sort the list by price that way lowest priced product is first 
		Collections.sort(productList, new Comparator<Product>() {
			public int compare(Product o1, Product o2) {
				return o1.getPrice().compareTo(o2.getPrice());
			}
		});
		Product lowestPrice = null;
		boolean duplicatesFound = false;
		Predicate<Product> allProducts = p -> p.getPrice()!=0; 
		OptionalDouble  average = productList.stream().filter(allProducts).mapToDouble(p->p.getPrice()).average();
		double temp = 0.0;

		for (int i = 0; i < productList.size(); i++) {
			temp = productList.get(i).getPrice();
			for (int j = i + 1; j < productList.size(); j++) {
				if (productList.get(j).getPrice() == temp) {
					duplicatesFound = true;
					break;
				}
			}
			if (duplicatesFound) {
				break;
			}
		}
		//if there are repeating prices(duplicates in price),pick the second lower price instead
		double productAverage = average.getAsDouble();
		for (int i = 0; i < productList.size(); i++) {
			lowestPrice = productList.get(i);
			if (lowestPrice.getPrice() > (productAverage * 0.5)) {
				if (duplicatesFound) {
					lowestPrice = productList.get(i + 1);
				}
				break;
			}
		}
		return lowestPrice;
	}

	public RecommendedProduct calculateRecommendedPrice(
			SearchCriteria searchCriteria, Product lowerPricedProduct) {
		// check the parameter for demand and supply
				boolean highDemand = searchCriteria.getDemand().equals(SupplyDemand.H) ? true
						: false;
				boolean highSupply = searchCriteria.getSupply().equals(SupplyDemand.H) ? true
						: false;
				
		double recommendedPrice = 0;
		String discountValueStr = null;
		if (highSupply && highDemand) {
			recommendedPrice = lowerPricedProduct.getPrice();
		} else if (!highSupply && !highDemand) {
			discountValueStr= PropertyManager.getInstance().getValue("lowSupply.lowDemand");
			recommendedPrice = (lowerPricedProduct.getPrice() + lowerPricedProduct
					.getPrice() * Double.parseDouble(discountValueStr));
			// sell at more that 10% chosen price
		} else if (!highSupply && highDemand) {
			  discountValueStr =  PropertyManager.getInstance().getValue("lowSupply.highDemand");
			recommendedPrice = (lowerPricedProduct.getPrice() + lowerPricedProduct
					.getPrice() * Double.parseDouble(discountValueStr));
			// sell more than 5%
		} else if (highSupply && !highDemand) {
			  discountValueStr =  PropertyManager.getInstance().getValue("highSupply.lowDemand");
			recommendedPrice = (lowerPricedProduct.getPrice() - lowerPricedProduct
					.getPrice() * Double.parseDouble(discountValueStr));
			// sell 5% less
		}
		RecommendedProduct chosenProduct = new RecommendedProduct();
		chosenProduct.setProduct(lowerPricedProduct);
		chosenProduct.setRecommendedPrice(recommendedPrice);
		return chosenProduct;
	}
}
