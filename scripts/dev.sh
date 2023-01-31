#!/bin/bash

# mvn clean package
trap ctrl_c INT

function ctrl_c () {
    printf "closing \n"

    docker-compose -f scripts/docker-compose.yml down
    
    exit 1
}

docker-compose -f scripts/docker-compose.yml up --build

ctrl_c