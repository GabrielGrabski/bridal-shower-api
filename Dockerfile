FROM maven:3.9.7-eclipse-temurin-21-alpine AS build

WORKDIR /build

COPY . .

RUN mvn clean install

FROM amazoncorretto:21-alpine-jdk

WORKDIR /app

COPY --from=build /build/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]