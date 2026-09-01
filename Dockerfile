# Stage 1 - setup a jdk build image
FROM eclipse-temurin:25.0.4_7-jdk-noble AS build_stage

WORKDIR /opt/notification-service

# here I can write both installations inside a single layer instead of two
RUN apt-get update && apt-get install maven -y

COPY . ./

RUN mvn clean package

# Stage 2 - setup the jre image
FROM eclipse-temurin:25.0.4_7-jre-noble AS runtime_stage

WORKDIR /opt/notification-service

COPY --from=build_stage /opt/notification-service/target/notification-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "notification-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081