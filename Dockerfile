FROM openjdk
COPY target/knifes-0.0.1-SNAPSHOT.jar knifes.jar
CMD ["java", "-jar", "knifes.jar"]