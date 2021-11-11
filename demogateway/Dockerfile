FROM adoptopenjdk/maven-openjdk11

EXPOSE 8081

WORKDIR /apps

#COPY . .

#RUN mvn clean install

#CMD mvn spring-boot:run

COPY ./target/*.jar /apps/

EXPOSE ${GATEWAY_PORT}

CMD "java" "-jar" "demogateway-0.0.1-SNAPSHOT.jar"