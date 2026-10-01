# Nexus Repository and Container Registry Strategy

## Why Nexus is used

Nexus acts as the central artifact and image repository for the enterprise delivery pipeline. It provides a trusted place to store built JARs, release artifacts, and Docker images that are promoted between environments.

## Repository types

- Maven repository: stores Java artifacts such as JAR and WAR files
- Docker registry: stores container images such as enterprise-sethu-app:1.0.0
- Snapshot repository: stores in-progress development builds
- Release repository: stores approved and versioned releases

## Why rebuilds must be consistent

Artifacts should not be rebuilt differently between environments because that creates drift, untraceable differences, and difficulty in diagnosing problems. The same approved artifact should flow through dev, QA, stage, and production promotion path, with only the deployment metadata changing.

## Example commands

```bash
mvn deploy
curl -u admin:admin http://localhost:8081/service/rest/repository/browse/maven-releases/
docker tag enterprise-sethu-app:1.0.0 nexus.example.com/enterprise-sethu-app:1.0.0
docker push nexus.example.com/enterprise-sethu-app:1.0.0
```

## Interview explanation

A release engineer’s role is to ensure artifacts are immutable, traceable, and consistent. Nexus provides the governance around build provenance and promotes repeatability across environments.
