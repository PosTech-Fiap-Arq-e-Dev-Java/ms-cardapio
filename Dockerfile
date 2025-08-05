FROM eclipse-temurin:17-jdk

WORKDIR /app

RUN apt-get update && apt-get install -y netcat-openbsd && rm -rf /var/lib/apt/lists/*

COPY target/*.jar /app/appMsCardapio.jar

COPY wait-for-it.sh /wait-for-it.sh
COPY entrypoint.sh /entrypoint.sh

RUN chmod +x /wait-for-it.sh /entrypoint.sh

EXPOSE 9909

ENTRYPOINT ["/entrypoint.sh"]
