#!/usr/bin/env sh

mvn -f pom.xml package

./../rancher-compose --project-name jarkko-authentication \
    --url http://192.168.99.100:8080/v1/projects/1a5 \
    --access-key DEEE8B2004E4767B6A4E \
    --secret-key U5fcHhvgjsMrsc35ggHRDeBte5xbXRnCdMtT38UN \
    -f docker-compose.yml \
    --verbose up \
    -d --force-upgrade \
    --confirm-upgrade