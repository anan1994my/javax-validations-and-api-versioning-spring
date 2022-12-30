#!/bin/sh
curl -X POST -H "Content-Type: application/json" \
    -d '{"name": "Jonny", "age": 28}' \
    http://localhost:8080/hello