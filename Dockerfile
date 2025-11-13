# Etapa 1: construir el JAR con Maven dentro del contenedor (Java 21)
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Carpeta de trabajo
WORKDIR /app

# Copiamos el pom y el código fuente
COPY pom.xml .
COPY src ./src

# Compilamos la aplicación (sin tests para que sea más rápido)
RUN mvn -q -DskipTests package

# Etapa 2: imagen final con solo el JAR (Java 21)
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiamos el JAR generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Puerto en el que escucha tu app Spring Boot
EXPOSE 8888

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
