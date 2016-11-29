package com.sample.pricing;

import java.util.List;

public class SearchCriteria {
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

private List<Product> productList;
public List<Product> getProductList() {
	return productList;
}

public void setProductList(List<Product> productList) {
	this.productList = productList;
}


 

}
