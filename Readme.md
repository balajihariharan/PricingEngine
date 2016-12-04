#Pricing Engine
   Pricing Engine is a simple POJO application to provide recommendation for frequently changing price.This project uses `maven` to build and `junit` library for testing.no other framework is utilized.
   There are two key components ;a `service` and a `Wrapper`.Service computes recommended price for a list of products.a wrapper class groups different products that 
   might come from different sources and in turn invokes service.
List of Products could come from external APIs or by hitting Database or a flat file
    
Maven is required to build this project,following maven command can be used to build the project

  `mvn clean install`

This command also executes junit test cases.

* jUnit test for service `PricingServiceImplTest` 
* jUnit test for Wrapper `PricingServiceWrapperTest`

Percentage value to discount/appraise is derived from properties file for given Supply and Demand.That way to change these settings ,we can avoid re-compiling.

**12/2/2016** would have considered following if i had a chance to change now.
* define Contructors for domains instead of getters/setters since it makes it easy to unit test.
* Use `set` instead of `List` and over ride `equals & hashCode() methods`
