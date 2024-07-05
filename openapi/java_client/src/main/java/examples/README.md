# Java API Client: Practical Implementation
This document explains the steps to start working with your Java client for consumption of Sedaro services.

Read more about Sedaro at [docs.sedaro.com](https://docs.sedaro.com).

### API Key

To access the Sedaro service via this API, you will need an API key.  You can generate an API key for your account in the
Sedaro [Management Console](https://satellite.sedaro.com/account). Once complete, pass the API key in all requests
via the `X_API_KEY` HTTP header.

*API keys grant full access to your account and should never be shared. If you think your API key has been compromised,
you can revoke it in the [Management Console](https://satellite.sedaro.com/account).*

### Community, Support, Discussion

If you have any issues or suggestions, please reach out:

1. Join the Sedaro Community [Slack](https://join.slack.com/t/sedaro-community/shared_invite/zt-1jps4i711-mXy88AZQ9AV7YcEXr8x7Ow)
2. Email us at support@sedarotech.com

### Known Issues

- Error responses are more specific than what is shown throughout the documentation.  A 4xx or 5xx error will be returned
in all error cases.  Only a `200` status indicates success.  See a given error response for additional details.
- The crudTemplate functionality is not fully supported for this client version.


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Generating the Java client


* To generate the Java client navigate to your `'sedaro-openapi'` project directory and run the following command:

```sh
openapi-generator generate -i ./spec.json -g java -o ./openapi/java_client
```

* To get a better understanding on how to use the client it is recommended to use the examples present in your `'openapi/java_client/src/main/java/examples'` directory. You will use the examples in this directory to interact with Sedaro API, this will be discussed in the upcoming steps.


## Installation

To install the API client library to your local Maven repository, navigate to `'openapi/java_client'` directory (this directory should contain your `'pom.xml'` file) and simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>4.11.36</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'openapi-java-client' jar has been published to maven central.
    mavenLocal()       // Needed if the 'openapi-java-client' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "org.openapitools:openapi-java-client:4.11.36"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-4.11.36.jar`
* `target/lib/*.jar`

## Getting Started

After following the [installation](#installation) instruction:

Navigate to your `'openapi/java_client/src/main/java/'examples'` directory, where you will find the following files:

* A `'Main.java'` file which contains the main method that calls methods created in `'Test.java'`.

* A `'Test.java'` file which contains examples demonstrating how to interact with the Sedaro API. You can modify the existing functions in this file or create your own functions as needed. Before making any alterations, it is recommended to run the pre-existing functions to get familiar with how to interact with Sedaro end points.

* A `'Secrets.java'` file that is used to retrieve the host URL, API key, branch IDs, workspace ID, or any other secrets from `'config.properties'`.

* A `'resources/config.properties'` file that contains key-value pairs of the secrets used to access the API. You need to retrieve these credentials from the Sedaro website [Home Page](https://satellite.sedaro.com) and assign them to the corresponding key in this file.

Example: (Please follow the same format, leaving a space before and after the equal sign)

    URL = https://api.sedaro.com

    API_KEY = ABCD

    WORKSPACE_ID = EFG

    SUPER_SAT_SCEN_ID = HIJ

You can now navigate to your `'openapi/java_client/src/main/java/examples'`, open your `'Main.java'` and run the methods implemented in `'Test.java'` or modify them as needed.

You can also refer to the generated `'README.md'` in your `'openapi/java_client'` for more details on methods' implementation.

## Recommendation

In a multithreaded environment, it is recommended to create a separate instance of `ApiClient` in each thread, to avoid any potential issues.



