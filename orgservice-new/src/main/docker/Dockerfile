FROM openjdk:8
RUN apt-get clean    && \
    apt-get update   && \
    apt-get install -y netcat

RUN mkdir -p /usr/local/organizationservice-new

ADD orgservice-new-0.0.1-SNAPSHOT.jar /usr/local/organizationservice-new/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
