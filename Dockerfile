FROM openjdk:8

ADD target/mongowebdemo-0.0.1-SNAPSHOT.jar mongowebdemo-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","mongowebdemo-0.0.1-SNAPSHOT.jar"]