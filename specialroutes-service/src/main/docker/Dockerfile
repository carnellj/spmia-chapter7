FROM openjdk:8
RUN apt-get clean    && \
    apt-get update   && \
    apt-get install -y netcat
EXPOSE 8910
RUN mkdir -p /usr/local/specialroutes-services
ADD specialroutesservice-0.0.1-SNAPSHOT.jar /usr/local/specialroutes-service/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
