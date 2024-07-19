# 使用官方的OpenJDK镜像作为基础镜像
FROM openjdk:8-jdk-alpine

# 设置工作目录
WORKDIR /app

# 将本地的JAR文件复制到镜像中
COPY target/production-ai-1.0-SNAPSHOT.jar /app/production-ai-1.0-SNAPSHOT.jar

# 暴露应用的端口
EXPOSE 8080

# 定义启动命令
CMD ["java", "-jar", "production-ai-1.0-SNAPSHOT.jar"]
