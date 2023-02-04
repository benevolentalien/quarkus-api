[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=benevolentalien_quarkus-api&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=benevolentalien_quarkus-api)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=benevolentalien_quarkus-api&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=benevolentalien_quarkus-api)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=benevolentalien_quarkus-api&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=benevolentalien_quarkus-api)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=benevolentalien_quarkus-api&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=benevolentalien_quarkus-api)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=benevolentalien_quarkus-api&metric=bugs)](https://sonarcloud.io/summary/new_code?id=benevolentalien_quarkus-api)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=benevolentalien_quarkus-api&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=benevolentalien_quarkus-api)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=benevolentalien_quarkus-api&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=benevolentalien_quarkus-api)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=benevolentalien_quarkus-api&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=benevolentalien_quarkus-api)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=benevolentalien_quarkus-api&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=benevolentalien_quarkus-api)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=benevolentalien_quarkus-api&metric=coverage)](https://sonarcloud.io/summary/new_code?id=benevolentalien_quarkus-api)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=benevolentalien_quarkus-api&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=benevolentalien_quarkus-api)
[![Java CI](https://github.com/benevolentalien/quarkus-api/actions/workflows/test.yml/badge.svg)](https://github.com/benevolentalien/quarkus-api/actions/workflows/test.yml)

# episodate Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

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

You can then execute your native executable with: `./target/episodate-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
