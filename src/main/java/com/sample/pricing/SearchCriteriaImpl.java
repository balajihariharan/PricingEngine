package com.sample.pricing;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class SearchCriteriaImpl implements SearchCriteria {
	public Product calculateLowestPrice(List<Product> products) {
		Product lowestPrice = null;
		boolean duplicatesFound = false;

		 
		Predicate<Product> allProducts = p -> p.getPrice()!=0; 
		OptionalDouble  average = products.stream().filter(allProducts).mapToDouble(p->p.getPrice()).average();
		

		double temp = 0.0;

		for (int i = 0; i < products.size(); i++) {
			temp = products.get(i).getPrice();
			for (int j = i + 1; j < products.size(); j++) {
				if (products.get(j).getPrice() == temp) {
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
		for (int i = 0; i < products.size(); i++) {
			lowestPrice = products.get(i);
			if (lowestPrice.getPrice() > (productAverage * 0.5)) {
				if (duplicatesFound) {
					lowestPrice = products.get(i + 1);
				}
				break;
			}
		}
		return lowestPrice;
	}
}
