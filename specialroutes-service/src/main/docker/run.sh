#!/bin/sh
echo "********************************************************"
echo "Waiting for the database server to start               *"
echo "********************************************************"
while ! `nc -z database 5432`; do sleep 3; done
echo "******** Database Server has started"

echo "********************************************************"
echo "Waiting for the eureka server to start                  "
echo "********************************************************"
while ! `nc -z eurekaserver 8761`; do sleep 3; done
echo "******* Eureka Server has started"

echo "********************************************************"
echo "Waiting for the configuration server to start          *"
echo "********************************************************"
while ! `nc -z configserver 8888`; do sleep 3; done
echo "*******  Configuration Server has started"

echo  "********************************************************"
echo "Waiting for the fluent server to start          *"
echo "********************************************************"
while ! `nc -z fluentd 24224`; do sleep 3; done
echo "*******  Fluentd Server has started"

echo "********************************************************"
echo "Starting Special Routes Service                           "
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Dserver.port=$SERVER_PORT   \
     -Deureka.client.serviceUrl.defaultZone=$EUREKASERVER_URI             \
     -Dspring.cloud.config.uri=$CONFIGSERVER_URI                          \
     -Dspring.profiles.active=$PROFILE                                   \
     -jar /usr/local/specialroutes-service/specialroutesservice-0.0.1-SNAPSHOT.jar
