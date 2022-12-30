#!/bin/sh
curl -X POST -H "Content-Type: application/vnd.com.v1+json" \
    -d '{"name": "Jonny"}' \
    http://localhost:8080/hello