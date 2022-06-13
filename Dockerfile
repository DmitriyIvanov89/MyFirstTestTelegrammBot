FROM adoptopenjdk/openjdk8:ubi
ARG JAR_FILE=target/myBot.jar
ARG JAR_LIB_FILE=target/lib/
ENV bot_token=5215836988:AAHlnTVEQVYsJtLBsDINg2crQgt1ttdnrV0
ENV bot_name=JimboJack88Bot
COPY ${JAR_FILE} app.jar
ADD ${JAR_LIB_FILE} lib/
ENTRYPOINT ["java","-Dbot_name=${bot_name}","-Dbot_token=${bot_token}","-jar","/app.jar"]