FROM openjdk:17
ADD my-spring-boot-app-0.0.1-SNAPSHOT.jar /usr/src/my-spring-boot-app-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "my-spring-boot-app-0.0.1-SNAPSHOT.jar"]
