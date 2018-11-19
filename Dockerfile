FROM maven:3.5.4-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
COPY keystore.p12 /usr/src/app
RUN mvn -f /usr/src/app/pom.xml -DskipTests clean package

FROM openjdk:8
COPY --from=build /usr/src/app/target/Shopping-1.0.0.jar /usr/app/Shopping-1.0.0.jar
COPY --from=build /usr/src/app/keystore.p12 /usr/src/app/keystore.p12
EXPOSE 8443
ENTRYPOINT ["java","-jar","/usr/app/Shopping-1.0.0.jar"]
