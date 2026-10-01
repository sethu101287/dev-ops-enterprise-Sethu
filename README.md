# Enterprise Sethu — DevOps Enterprise Platform

This repository is the foundation for a realistic enterprise Java DevOps + Middleware platform project named Enterprise Sethu. The project is intentionally designed to support:

- Senior DevOps Engineer interviews
- Senior Release Engineer interviews
- DevOps Lead interviews
- Middleware Administrator interviews
- Kubernetes / OpenShift interview practice
- CI/CD pipeline demonstrations
- Production troubleshooting exercises
- Local hands-on lab practice using Docker, Maven, and Kubernetes tooling

## Phase 1: Project Foundation

This first phase establishes the repository structure, Java/Maven application, REST API, tests, Git initialization, and Linux/Maven validation. The next phases will add Jenkins, SonarQube, Docker, Trivy, Nexus, middleware, PostgreSQL, Kubernetes, OpenShift, Helm, GitOps, monitoring, and release engineering workflows.

## Goals of this project

- Demonstrate how code moves from a developer commit to a controlled enterprise deployment
- Show quality gates, security scanning, artifact promotion, and middleware deployment
- Highlight Java platform, JVM, database, and Kubernetes/OpenShift operations
- Provide a realistic platform for interview storytelling and resume explanation

## Application name

Enterprise Sethu Platform

## Maven coordinates

- GroupId: com.enterprise.Sethu
- ArtifactId: enterprise-Sethu-app
- Version: 1.0.0-SNAPSHOT
- Java: 21
- Build: Maven

## Repository structure

The repository is being expanded in phases. The current foundation includes Java source, test code, scripts, and documentation.

## Current status

- Repository structure created
- Java application scaffolded
- REST API implemented
- Unit tests added
- Git initialized; Phase 1 foundation committed as `bc03a75`
- Previous Surefire report records 2 passing tests; current Maven validation is pending
- Linux validation is pending because WSL is not installed in the current Windows environment
- Jenkins and later phases are out of scope until Phase 1 validation is complete

This repository is intentionally staged for hands-on enterprise learning and interview preparation.

## Existing build evidence

An existing Surefire report records a successful earlier test run. This is historical evidence and has not been reproduced in the current environment.

The current Windows shell has Java 25 available but no `mvn` command. The project targets Java 21. WSL is also not installed, so Linux command validation remains pending. The next step is to prepare a Linux environment, then validate the Java/Maven build before proceeding beyond Phase 1.
