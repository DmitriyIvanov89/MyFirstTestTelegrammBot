FROM adoptopenjdk/openjdk8:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_TOKEN=5215836988:AAHlnTVEQVYsJtLBsDINg2crQgt1ttdnrV0
ENV BOT_NAME=JimboJack88Bot
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-DBOT_NAME=${BOT_NAME}","-DBOT_TOKEN=${BOT_TOKEN}","-jar","/app.jar"]