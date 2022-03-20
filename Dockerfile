FROM openjdk:8
ADD build/libs/pokemon-service-1.0.jar pokemon-service.jar
ENTRYPOINT ["java","-jar","/pokemon-service.jar"]