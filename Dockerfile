FROM amazoncorretto:21-alpine-jdk
LABEL authors="win"
COPY target/product.jar product.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "product.jar"]