FROM openjdk:11
ADD target/desafiodepropostas.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar" , "app.jar"]