FROM openjdk:11
ADD target/desafiodepropostas.jar aplicattion.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar" , "aplicattion.jar"]