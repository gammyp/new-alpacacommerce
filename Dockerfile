FROM maven:3.5.4-jdk-8
COPY . /
RUN mvn -DskipTests clean package
EXPOSE 8443
ENTRYPOINT ["java","-jar","target/Shopping-1.0.0.jar"]
