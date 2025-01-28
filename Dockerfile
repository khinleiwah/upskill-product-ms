FROM amazoncorretto:21-alpine-jdk
LABEL authors="win"
COPY target/product-service.jar product-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "product-service.jar"]