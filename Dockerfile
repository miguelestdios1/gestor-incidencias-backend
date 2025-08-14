FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/gestor-incidencias-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
