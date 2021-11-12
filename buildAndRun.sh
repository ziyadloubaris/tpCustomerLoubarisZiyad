#!/bin/sh
mvn clean package && docker build -t com.mycompany/tp1LoubarisZiyad .
docker rm -f tp1LoubarisZiyad || true && docker run -d -p 9080:9080 -p 9443:9443 --name tp1LoubarisZiyad com.mycompany/tp1LoubarisZiyad