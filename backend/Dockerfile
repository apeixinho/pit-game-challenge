FROM maven:3-jdk-8-alpine

VOLUME /tmp

ENV JAVA_OPTS=""

RUN addgroup -S app && adduser -S -g app app && apk update && apk upgrade

WORKDIR /home/app

# COPY target/*.jar app.jar
COPY . $WORKDIR
RUN mvn clean install && \
    chown -R app:app /home/app && \
    cp -v target/*.jar app.jar

EXPOSE 8888

USER app

CMD java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar
# CMD ["java", "$JAVA_OPTS","-Djava.security.egd=file:/dev/./urandom -jar app.jar"]
# CMD [ "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]
# ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]