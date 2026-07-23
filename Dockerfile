FROM maven:3-eclipse-temurin AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-alpine
COPY --from=build /target/mortall-0.0.1-SNAPSHOT.jar mortall.jar
EXPOSE 8080
LABEL authors="hp Elitebook"

ENTRYPOINT ["java", "-jar","mortall.jar"]