# Giai đoạn 1: Lôi bộ đồ nghề JDK và Gradle ra để build
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app

# Copy bộ khung Gradle vào trước
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# QUAN TRỌNG: Cấp quyền chạy cho file gradlew
RUN chmod +x ./gradlew

# Copy mã nguồn vào
COPY src ./src

# Gõ lệnh build ra file .jar (bỏ qua test cho lẹ)
RUN ./gradlew clean build -x test --no-daemon

# Giai đoạn 2: Lấy file .jar vừa build đem đi chạy
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Lưu ý: Gradle nó vứt file build vào thư mục build/libs chứ đéo phải target như Maven
COPY --from=build /app/build/libs/*.jar app.jar

# Chạy server
ENTRYPOINT ["java", "-Dserver.port=${PORT:8080}", "-jar", "app.jar"]