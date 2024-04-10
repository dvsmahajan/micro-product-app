FROM openjdk:21-jdk
EXPOSE 7777
ARG JAR_FILE=product-app-1.jar
ADD ${JAR_FILE} product-app-1.jar
ENTRYPOINT ["java","-jar","/product-app-1.jar"]