FROM openjdk:8-jdk-alpine
ADD target/Core_Category-*.jar corecategory.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar", "corecategory.jar"]