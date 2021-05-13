FROM openjdk:11
ADD target/desafiodepropostas.jar aplication.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar" , "aplication.jar"]