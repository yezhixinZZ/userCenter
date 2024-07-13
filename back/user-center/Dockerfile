# 使用 Adoptium 的 JDK 21 镜像作为基础镜像
FROM ghcr.io/adoptium/temurin:21-jdk-hotspot AS builder

# 设置工作目录
WORKDIR /app
COPY pom.xml .
COPY src ./src

# 构建项目
RUN mvn package -DskipTests

CMD ["java", "-jar", "/app/target/user-center-0.0.1-SNAPSHOT.jar"]