#Pricing Engine
       Pricing Engine is a simple POJO application to provide recommendation for frequently changing price for a list of products.This project uses `maven` to build,`junit` library is used for testing, besides that no other framework is utilized.
    There are two key classes ;a service and a Wrapper. Service returns recommendation for a list of products. a wrapper class groups different products that might come from different sources and in turn invokes service.List of Products could come from external APIs or by hitting Database or a flat file.
    
Maven is required to build this project,following maven command can be used to build the project.
  `mvn clean install`
  

for Service usage,refer `PricingServiceImplTest` 
for Wrapper usage refer `PricingServiceWrapperTest`

Percentage value to discount/appraise is derived from properties file. This application can be developed using spring framework as well.