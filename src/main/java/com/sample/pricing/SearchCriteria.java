package com.sample.pricing;

import java.util.List;

public interface SearchCriteria {
	public Product calculateLowestPrice(List<Product> products);
}