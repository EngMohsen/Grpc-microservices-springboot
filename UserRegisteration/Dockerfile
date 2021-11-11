FROM adoptopenjdk/maven-openjdk11

WORKDIR /apps

COPY ./target/*.jar /apps/

ENV USER_PORT=7070

EXPOSE ${USER_PORT}

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.9.0/wait /wait

RUN chmod +x /wait

CMD /wait && "java" "-jar" "UserRegisteration-0.0.1-SNAPSHOT.jar"