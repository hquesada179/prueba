# Etapa 1: construir el JAR con Maven dentro del contenedor
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Carpeta de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el pom y el código fuente
COPY pom.xml .
COPY src ./src

# Compilamos la aplicación (sin tests para que sea más rápido)
RUN mvn -q -DskipTests package

# Etapa 2: imagen final con solo el JAR
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiamos el JAR generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Puerto por defecto de Spring Boot
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
