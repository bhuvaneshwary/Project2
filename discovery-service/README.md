# Discovery Service

This is a discovery service will register the Pricing service and the Vehicle service.

## Instructions

Via shell it can be started using

```
$ mvn clean package
```

```
$ java -jar target/discovery-service-0.0.1-SNAPSHOT.jar
```

The service is available by default on port `8761`. You can log in on the service using: http://localhost:8761

You can also import it as a Maven project on your preferred IDE and 
run the class `DiscoveryServiceApplication`.