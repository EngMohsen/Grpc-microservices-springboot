FROM adoptopenjdk/maven-openjdk11

WORKDIR /apps

#COPY . .

#RUN mvn clean install

#CMD mvn spring-boot:run

COPY ./target/*.jar /apps/

ENV USER_PORT=7070

EXPOSE ${USER_PORT}

CMD "java" "-jar" "UserRegisteration-0.0.1-SNAPSHOT.jar"