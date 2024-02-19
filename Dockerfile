FROM openjdk:17

COPY .mvn/ usr/.mvn/
COPY mvnw pom.xml usr/
RUN chmod +x usr/mvnw

COPY src usr/src

WORKDIR usr/
RUN ./mvnw -B -DskipTests clean package

WORKDIR target/
ENTRYPOINT ["java","-jar", "spring-boot-app-0.0.1.jar"]
