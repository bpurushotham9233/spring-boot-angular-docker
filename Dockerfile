# Stage 1: Build Angular application
FROM node:14 as angular-builder

WORKDIR /app

COPY angular-app/ ./

RUN npm install
RUN npm run build -- --prod

# Stage 2: Build Spring Boot application
FROM maven:3.8.4-jdk-11 as spring-boot-builder

WORKDIR /app

COPY spring-boot-app/ ./

RUN mvn clean install

# Stage 3: Create final image
FROM openjdk:11-jre-slim

WORKDIR /app

# Copy compiled Spring Boot application
COPY --from=spring-boot-builder /app/target/*.jar app.jar

# Copy compiled Angular build files to Spring Boot resources
COPY --from=angular-builder /app/dist/angular-app /app/src/main/resources/static

EXPOSE 8082

CMD ["java", "-jar", "app.jar"]

