


# ─────────────────────────────────────────────
# Stage 1 – Build the application with Maven
# ─────────────────────────────────────────────
FROM maven:3.9.6-eclipse-temurin-21 AS builder
 
WORKDIR /app
 
# Copy dependency descriptors first so Docker can cache this layer.
# The source code is copied separately so a code change does not
# invalidate the downloaded dependencies.
COPY pom.xml .
RUN mvn dependency:go-offline -q
 
COPY src ./src
RUN mvn clean package -DskipTests -q
 
# ─────────────────────────────────────────────
# Stage 2 – Create the lean runtime image
# ─────────────────────────────────────────────
FROM eclipse-temurin:21-jre-alpine
 
WORKDIR /app
 
# Add a non-root user for security best practice
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser
 
# Copy only the built jar from the builder stage
COPY --from=builder /app/target/attendance-*.jar attendance.jar
 
EXPOSE 8080
 
ENTRYPOINT ["java", "-jar", "attendance.jar"]