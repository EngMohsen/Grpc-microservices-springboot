#!/bin/bash
#delete elasticsearch 
kubectl delete -f ./kubernetes/elasticsearch.yaml

#delete logstash 
kubectl delete -f ./kubernetes/logstash.yaml

#delete kibana 
kubectl delete -f ./kubernetes/kibana.yaml


#delete hello service  
kubectl delete -f ./kubernetes/Hello-deployment-service.yaml

#delete user service  
kubectl delete -f ./kubernetes/user-deploymnet-service.yaml


#delete gateway service  
kubectl delete -f ./kubernetes/gateway-deployment-service.yaml

#stop minikube
minikube stop 

