FROM adoptopenjdk/maven-openjdk11

WORKDIR /apps
#COPY . .

#RUN mvn clean install
#CMD mvn spring-boot:run
COPY ./target/*.jar /apps/

ENV HELLOWORLD_PORT=6060

EXPOSE ${HELLOWORLD_PORT}

CMD "java" "-jar" "helloworld-0.0.1-SNAPSHOT.jar"