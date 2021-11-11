#!/bin/bash
mvn clean install
docker-compose -f docker-compose-ELK.yml up --build