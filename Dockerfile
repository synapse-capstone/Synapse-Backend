# 1단계: 빌드 단계 (선택) - multi-stage 사용 가능
FROM openjdk:17-jdk-slim
WORKDIR /app

# ARG로 jar 파일 이름 전달
ARG JAR_FILE=build/libs/synapse-0.0.1-SNAPSHOT.jar

# jar 파일 복사
COPY ${JAR_FILE} app.jar

# 포트 노출
EXPOSE 8080

# 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
