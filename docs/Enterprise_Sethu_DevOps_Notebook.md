# Enterprise Sethu DevOps Notebook

This notebook is the operational journal for the Enterprise Sethu platform project.

## Commands learned

- `git init`
- `git status`
- `git add .`
- `git commit -m "Initial project foundation - Enterprise Sethu"`
- `java -version`
- `mvn -version`
- `mvn test`

## Concepts learned

- Enterprise multi-stage DevOps flow
- Java application scaffolding with Spring Boot
- REST API development and health endpoints
- Test-driven validation for application health
- Git branch strategy for enterprise delivery
- Java/Maven environment setup and build validation

## Validation record

An existing Surefire report records a successful earlier test run. It is historical evidence; Maven could not be rerun in the current environment.

Evidence:
- Tests run: 2
- Failures: 0
- Errors: 0
- Prior report status: SUCCESS
- Current Windows environment: Java 25 detected; project targets Java 21; Maven is not available on PATH
- Linux validation: pending; WSL is not installed

## Architecture

Developer -> GitHub -> Jenkins -> Maven -> Unit Tests -> SonarQube -> Docker -> Trivy -> Registry -> Middleware -> DB -> Kubernetes/OpenShift -> Helm -> Argo CD -> Monitoring -> Release

## Troubleshooting

- Current blocker: Maven is not available on PATH, so the build cannot be rerun yet.
- Current blocker: WSL is not installed, so Linux validation cannot be performed yet.
- Java 25 is available in Windows, while this project targets Java 21; validate with a Java 21 runtime/toolchain when preparing the build environment.

## Interview questions

- How do you structure an enterprise Java project for DevOps interview readiness?
- What are the differences between merge and rebase?
- Why is a health endpoint critical in enterprise applications?

## Interview answers

- A solution should demonstrate business capability, automation, quality gates, and production-style deployment flow.
- Merge preserves branch history; rebase creates a linear history. The choice depends on team policy and operational needs.
- A health endpoint validates availability and helps readiness checks, monitoring, and release validation.

## Git commits

- `bc03a75` - Initial project foundation - Enterprise Sethu

## Release notes

- Phase 1 foundation established
- Java API and test baseline added
- Linux and Git workflow notes added

## Lessons learned

- Build validation depends on environment readiness.
- Every phase must have a clear validation step before moving to the next stage.

## Current project status

- Phase 1 in progress
- Application scaffold, REST endpoints, and two tests are present in the initial commit
- Existing test report records 2 passing tests, but there is no current rerun
- Linux and current Maven validations are pending
- Jenkins and later phases must wait for Phase 1 validation
