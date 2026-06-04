# Giai đoạn 1: Lôi bộ đồ nghề JDK và Gradle ra để build
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

RUN chmod +x ./gradlew

COPY src ./src

# Ép Gradle chỉ được xài tối đa 256MB RAM!
RUN ./gradlew clean build -x test --no-daemon -Dorg.gradle.jvmargs="-Xmx256m -XX:MaxMetaspaceSize=128m"

# Giai đoạn 2: Lấy file .jar vừa build đem đi chạy
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

# Ép server Spring Boot lúc chạy cũng chỉ được xài tối đa 300MB RAM để khỏi sập
ENTRYPOINT ["java", "-Xmx300m", "-Dserver.port=${PORT:8080}", "-jar", "app.jar"]