FROM openjdk:17-jdk-slim
WORKDIR /app

# ARG로 jar 파일 이름 지정 (기본값은 synapse-0.0.1-SNAPSHOT.jar)
ARG JAR_FILE=synapse-0.0.1-SNAPSHOT.jar

# COPY 시 실제 경로를 build/libs/${JAR_FILE}로 지정
COPY build/libs/${JAR_FILE} app.jar

# 포트 노출
EXPOSE 8080

# 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
