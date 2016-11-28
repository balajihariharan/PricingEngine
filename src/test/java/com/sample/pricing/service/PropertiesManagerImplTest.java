package com.sample.pricing.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class PropertiesManagerImplTest {
	 
	@Before
	public void preLoad(){
		 
	}
	@Test
	public void testProperties() {
		assertThat(PropertyManager.getInstance().getValue("lowSupply.lowDemand"),equalTo(".1"));
	}

}
