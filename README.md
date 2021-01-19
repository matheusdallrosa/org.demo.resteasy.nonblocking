# This project is creates a CloseableHttpAsyncClient with IOReactorConfig for just one IO thread.

# Requirements
- Java 11
- maven 3.6.4

# Steps to run it
- mvn clean package
- java --class-path target/deps/*:target/org.demo.resteasy.nonblocking-1.0-SNAPSHOT.jar org.demo.resteasy.NonBlockingClient

When you run this project it creates only one IO thread.