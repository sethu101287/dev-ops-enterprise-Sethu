# Release Strategy for Enterprise Sethu

## Semantic versioning

- MAJOR: incompatible or fundamental change
- MINOR: backward-compatible feature addition
- PATCH: fixes, compatibility-safe corrections, or hotfixes

Examples:
- 1.0.0
- 1.0.1
- 1.1.0
- 2.0.0

## Promotion model

The project uses a promotion-based release model in which the same approved artifact is promoted across environments instead of being rebuilt with environment-specific changes.

## Release flow

1. Code freeze
2. Build and unit test
3. SonarQube validation
4. Security scan
5. Container image creation
6. Registry upload
7. QA deployment
8. Validation
9. UAT
10. Change approval
11. Production deployment
12. Smoke test
13. Monitoring
14. Release closure

## Interview answer

A release engineer should explain that release control is not just deployment; it is governance. Every artifact, environment, validation checkpoint, and rollback decision needs traceability and evidence.
