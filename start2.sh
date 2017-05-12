#!/usr/bin/env sh

mvn -f pom.xml package

./../rancher-compose --project-name jarkko-authentication \
    --url http://192.168.99.101:8080/v1/projects/1a5 \
    --access-key E8547DE92C7C90E1AF13 \
    --secret-key qhrsLcaC1za8XTZCGFnYnkL6EBiiP97b89bNMvjq \
    -f docker-compose.yml \
    --verbose up \
    -d --force-upgrade \
    --confirm-upgrade