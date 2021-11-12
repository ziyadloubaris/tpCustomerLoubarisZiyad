@echo off
call mvn clean package
call docker build -t com.mycompany/tp1LoubarisZiyad .
call docker rm -f tp1LoubarisZiyad
call docker run -d -p 9080:9080 -p 9443:9443 --name tp1LoubarisZiyad com.mycompany/tp1LoubarisZiyad