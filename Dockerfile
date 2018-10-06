FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/thinkpro-transaction-0.0.1-SNAPSHOT.jar thinkpro-transaction.jar
RUN sh -c 'touch /thinkpro-transaction.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/thinkpro-transaction.jar"]
EXPOSE 9093
