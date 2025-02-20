FROM eclipse-temurin:21-jdk AS build

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia os arquivos do projeto para o contêiner
COPY . .

# Executa o build da aplicação usando Gradle
RUN ./gradlew clean build --no-daemon

# Etapa de runtime
FROM eclipse-temurin:21-jre

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado na etapa de build
COPY --from=build /app/build/libs/*.jar app.jar

# Define o comando de execução
CMD ["java", "-jar", "app.jar"]
