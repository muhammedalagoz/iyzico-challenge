FROM java:8
VOLUME /tmp
ADD target/challenge-0.0.1-SNAPSHOT.jar challenge.jar
RUN bash -c 'touch /challenge.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","/challenge.jar"]
