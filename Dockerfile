# ベースイメージ
FROM openjdk:17-jdk-slim

# 作業ディレクトリを設定
WORKDIR /app

# Spring BootアプリケーションのJARファイルをコピー
COPY build/libs/HairRemovalApp-0.0.1-SNAPSHOT.jar app.jar

# アプリケーションを起動するエントリーポイント
ENTRYPOINT ["java", "-jar", "app.jar"]