# �x�[�X�C���[�W
FROM openjdk:17-jdk-slim

# ��ƃf�B���N�g����ݒ�
WORKDIR /app

# Spring Boot�A�v���P�[�V������JAR�t�@�C�����R�s�[
COPY build/libs/HairRemovalApp-0.0.1-SNAPSHOT.jar app.jar

# �A�v���P�[�V�������N������G���g���[�|�C���g
ENTRYPOINT ["java", "-jar", "app.jar"]