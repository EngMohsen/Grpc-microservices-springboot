#!/bin/bash
#Starting minikube
minikube start --driver=docker

#create elasticsearch 
kubectl apply -f ./kubernetes/elasticsearch.yaml

#create logstash 
kubectl apply -f ./kubernetes/logstash.yaml

#create kibana 
kubectl apply -f ./kubernetes/kibana.yaml


#create hello service  
kubectl apply -f ./kubernetes/Hello-deployment-service.yaml

#create user service  
kubectl apply -f ./kubernetes/user-deploymnet-service.yaml


#create gateway service  
kubectl apply -f ./kubernetes/gateway-deployment-service.yaml