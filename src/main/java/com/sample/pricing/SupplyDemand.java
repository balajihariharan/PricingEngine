package com.sample.pricing;

public enum SupplyDemand {
	L("LOW"),H("HIGH");
	private String parameter;
	private SupplyDemand(String parameter){
		this.parameter = parameter;
	}
	public String getParameter(){
		return parameter;
	}
}
