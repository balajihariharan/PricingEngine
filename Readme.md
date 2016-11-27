This is a sample project to provide best price for a list of products.It is a simple POJO application, with some unit tests. 
    There are two key classes ;a service and a Wrapper. Service returns recommendation for a list of products. a wrapper class groups different products that might come from different sources and then provides recommendation for those products.Product could be from external APIs or by hitting Database or from a flat file.
    
Build the project
  `mvn clean install`

for Service usage,refer `PricingServiceImplTest` and for Wrapper usage refer `PricingServiceWrapperTest`