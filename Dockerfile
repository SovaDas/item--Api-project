# Stage 1: Build the application
# Stage 1: Build the application using Maven
# We use 'eclipse-temurin' because the old 'openjdk' images are no longer available.
FROM maven:3.8.5-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
# Using the supported Eclipse Temurin JRE image for a smaller, faster container.
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]