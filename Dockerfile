FROM openjdk:11
EXPOSE 8082
ADD target/devops.jar test1.jar
ENTRYPOINT ["java","-jar","/test1.jar"]