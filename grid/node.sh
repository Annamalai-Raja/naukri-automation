#!/bin/bash

if [ -z "$1" ]; then
    echo "Usage: $0 <IP_ADDRESS>"
    exit 1
fi

IP_ADDRESS=$1

java -jar selenium.jar node --selenium-manager true --publish-events tcp://"$IP_ADDRESS":4442 --subscribe-events tcp://"$IP_ADDRESS":4443
