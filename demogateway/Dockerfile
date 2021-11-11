FROM adoptopenjdk/maven-openjdk11

EXPOSE 8081

WORKDIR /apps

COPY ./target/*.jar /apps/

EXPOSE ${GATEWAY_PORT}

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.9.0/wait /wait
RUN chmod +x /wait

CMD /wait && "java" "-jar" "demogateway-0.0.1-SNAPSHOT.jar"