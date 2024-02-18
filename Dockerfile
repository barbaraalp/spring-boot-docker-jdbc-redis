FROM openjdk:17
ADD spring-boot-app-0.0.1.jar /usr/src/spring-boot-app-0.0.1.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "spring-boot-app-0.0.1.jar"]
