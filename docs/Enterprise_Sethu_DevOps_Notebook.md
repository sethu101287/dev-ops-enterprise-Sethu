# Enterprise Sethu DevOps Notebook

This notebook is the operational journal for the Enterprise Sethu platform project.

## Commands learned

- `git init`
- `git status`
- `mvn test` (environment currently blocked because Maven is not installed on the local host)

## Concepts learned

- Enterprise multi-stage DevOps flow
- Java application scaffolding with Spring Boot
- REST API development and health endpoints
- Test-driven validation for application health
- Git branch strategy for enterprise delivery

## Architecture

Developer -> GitHub -> Jenkins -> Maven -> Unit Tests -> SonarQube -> Docker -> Trivy -> Registry -> Middleware -> DB -> Kubernetes/OpenShift -> Helm -> Argo CD -> Monitoring -> Release

## Troubleshooting

- Missing Maven was identified as an environment blocker.
- The project foundation is created and ready to continue once Java/Maven is installed or available in the environment.

## Interview questions

- How do you structure an enterprise Java project for DevOps interview readiness?
- What are the differences between merge and rebase?
- Why is a health endpoint critical in enterprise applications?

## Interview answers

- A solution should demonstrate business capability, automation, quality gates, and production-style deployment flow.
- Merge preserves branch history; rebase creates a linear history. The choice depends on team policy and operational needs.
- A health endpoint validates availability and helps readiness checks, monitoring, and release validation.

## Git commits

- Initial project foundation created

## Release notes

- Phase 1 foundation established
- Java API and test baseline added
- Linux and Git workflow notes added

## Lessons learned

- Build validation depends on environment readiness.
- Every phase must have a clear validation step before moving to the next stage.

## Current project status

- Phase 1 in progress
- Application scaffold created
- Environment blocker: Maven not present locally
- Next step: install or verify Java/Maven toolchain and rerun validation
