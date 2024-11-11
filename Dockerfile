# Use a Java 21 slim image as the base
FROM openjdk:21-slim
LABEL authors="Isaac LLanda"

# Extract the application JAR from the target directory
COPY target/*.jar app.jar

# Expose the port used by your Spring Boot application (typically 8080)
EXPOSE 8079

# Start the application using the JAR
CMD ["java", "-jar", "/app.jar"]
