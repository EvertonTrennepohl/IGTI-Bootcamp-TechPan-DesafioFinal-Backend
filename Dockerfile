# Estagio de Build (Usa Maven com Java 11)
FROM maven:3.8.5-openjdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

# Estagio de Execucao (Usa JRE 11 slim para ser mais leve)
FROM openjdk:11-jre-slim
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]