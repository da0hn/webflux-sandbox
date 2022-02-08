#!/usr/bin/env bash

rm -rf ./target
./mvnw -DskipTests=true clean package
mv ./target/*.jar ./target/app.jar
