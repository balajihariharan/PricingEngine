package com.sample.pricing;

import java.util.List;

public class PricingCriteria {
private SupplyDemand demand;
public SupplyDemand getDemand() {
	return demand;
}

public void setDemand(SupplyDemand demand) {
	this.demand = demand;
}

public SupplyDemand getSupply() {
	return supply;
}

public void setSupply(SupplyDemand supply) {
	this.supply = supply;
}

private SupplyDemand supply;

private List<Product> products;


public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

}
