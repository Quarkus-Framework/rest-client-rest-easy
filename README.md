# rest-client-rest-easy Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

##Context
CRUD application with Quarkus, which use the RestClient to interact with external WebService exposed 
by `https://api.tvmaze.com/api` that return tv series episodes.

The application, using a Proxy class, create an HTTP request, process the result and return the HTTP response.
Example request: `http://localhost:8080/tvseries?title=game of thrones`

It use of OpenAPI for write documentation like Swagger: after compile the application,
have to digit on browser: `http://localhost:8080/q/openapi`

- In the application.properties we add proxy properties for interact with external WebService
of `https://api.tvmaze.com/api`

- For show the Swagger you have to digit: `http://localhost:8080/q/swagger-ui`

- For Packaging the application, digit: mvn compile package
After this, running the application digiting: 
java -jar target/quarkus-app/rest-client-rest-easy-1.0.0-SNAPSHOT.jar

## Tecnologies used
Extension:
- RESTEasy: write rest service
- OpenAPI: shows Apis documentation and Swagger
- Rest-Client: use a proxy class for make http request

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/rest-client-rest-easy-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- REST Client Classic ([guide](https://quarkus.io/guides/rest-client)): Call REST services
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing JAX-RS and more

## Provided Code

### REST Client

Invoke different services through REST with JSON

[Related guide section...](https://quarkus.io/guides/rest-client)

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
