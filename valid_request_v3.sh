#!/bin/sh
curl -X POST -H "Content-Type: application/vnd.com.v3+json" \
    -d '{"name": "Jonny", "age": 28, "phoneNumber": "+1234567", "country": "Morocco"}' \
    http://localhost:8080/hello