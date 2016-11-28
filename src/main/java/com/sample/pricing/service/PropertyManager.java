package com.sample.pricing.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyManager {
	private static final String ENV_PROPERTIES = "pricing-env.properties";
	private Properties properties = null; 
	private PropertyManager(){
		
		
	}
	private static PropertyManager instance = null; 
	private static Object lock = new Object();
	public static PropertyManager getInstance(){
		if (instance == null) {
		    synchronized (lock) {
		      if (instance == null) {
		        instance = new PropertyManager();
		        try {
					instance.loadProperties();
				} catch (IOException e) {
					e.printStackTrace();
				}
		      }
		    }
		  }
		  return instance;
	}
	public  String getValue(String key){
		return properties.getProperty(key);
	}
	private void loadProperties()  throws IOException {
		try {
	    	properties = new Properties();
	    	FileInputStream  in = new FileInputStream(ENV_PROPERTIES);
	        properties.load(in);
	        in.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("IOException occured "+e.getMessage());
			throw e;
		}
	}
}
