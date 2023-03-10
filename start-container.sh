#! /usr/bin/env bash

#docker-compose -f authorization_server.yml down
#docker-compose -f authorization_server.yml up -d

docker-compose -f C:/Desenvolvimento/sistemas/review-camunda-poc/infra/docker/docker-compose.yml down
docker-compose -f C:/Desenvolvimento/sistemas/review-camunda-poc/infra/docker/docker-compose.yml up -d

echo 'Stack started !'