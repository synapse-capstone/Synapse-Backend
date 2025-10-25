# Dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

# build/libs 안의 JAR 파일을 app.jar로 복사
COPY build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
