# Use an unofficial or custom JDK 22 runtime as a parent image (if available)
FROM openjdk:22-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the host machine to the container
COPY target/EcommerceApplication-0.0.1-SNAPSHOT.jar /app/EcommerceApplication.jar

# Expose the port your application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "EcommerceApplication.jar"]
