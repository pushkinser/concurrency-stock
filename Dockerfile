FROM maven:3.9.4-amazoncorretto-21 as build
WORKDIR /usr/src/app
COPY pom.xml .
COPY src src
RUN mvn -B package -DskipTests
FROM openjdk:17
COPY --from=build /usr/src/app/target/*.jar /usr/src/app/*.jar
ENTRYPOINT ["java", "-jar", "/usr/src/app/*.jar"]
