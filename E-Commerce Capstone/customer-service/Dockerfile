FROM openjdk:18
EXPOSE 4001
ADD target/customer-service-0.0.1-SNAPSHOT.jar customer-service.jar
ENTRYPOINT ["java","-jar","customer-service.jar"]