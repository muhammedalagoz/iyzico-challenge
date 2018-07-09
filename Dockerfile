FROM java:8
VOLUME /tmp
COPY target/challenge-0.0.1-SNAPSHOT.jar challenge.jar
ENTRYPOINT ["java","-jar","/challenge.jar"]