# Build Stage
FROM openjdk:17-oracle AS builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean package -DskipTests

# Run Stage
FROM openjdk:17-oracle AS final
WORKDIR /opt/app
EXPOSE 8090
ENV DB_URL=jdbc:postgresql://pgdb:5434/test
COPY --from=builder /opt/app/target/auth_demo*.jar /opt/app/app.jar
COPY src/main/resources /opt/app/src/main/resources
CMD java -jar
ENTRYPOINT ["java","-jar","-Dspring.datasource.url=${DB_URL}",  "/opt/app/app.jar"]

#FROM openjdk:17-oracle
#VOLUME /tmp
#COPY target/auth_demo*.jar  app.jar
#EXPOSE 8090
#ENTRYPOINT ["java","-jar", "app.jar"]
