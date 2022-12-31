#!/bin/sh
curl -X POST -H "Content-Type: application/vnd.com.v2+json" \
    -d '{"name": "Jonny", "age": 28, "phoneNumber": "+1234567"}' \
    http://localhost:8080/hello