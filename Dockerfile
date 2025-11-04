## Use a smaller base image for Java applications with JDK 17
#FROM openjdk:17-jdk-alpine
#
## Copy the built JAR file into the container
#COPY *.jar app.jar
#
## Command to run the application when the container starts
#ENTRYPOINT ["java","-jar","/app.jar"]
#EXPOSE 8080


# Stage 1: Build the application -  multi stage docker for lean build
FROM gradle:8.4-jdk17 AS builder

# Copy project files to container
COPY . /app

# Run Gradle build - no test done to minimise build time
RUN cd /app && gradle clean build -x test

# Stage 2: Run the application - trusted eclipse temurin image for slimmer faster and secure image
FROM eclipse-temurin:21-jdk-jammy

# Copy the JAR from the builder stage
COPY --from=builder /app/build/libs/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose application port (optional, e.g., 8080)
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]