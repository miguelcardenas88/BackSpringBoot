# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the build.gradle and settings.gradle files
COPY build.gradle settings.gradle /app/

# Copy the gradle wrapper files
COPY gradlew /app/
COPY gradle /app/gradle

# Download the dependencies
RUN ./gradlew build -x test --no-daemon

# Copy the rest of the application code
COPY . /app

# Build the application
RUN ./gradlew build -x test --no-daemon

# Expose the port the application runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "build/libs/ejercicio.jar"]