# SonarQube Quality Gates for Enterprise Sethu

## Why SonarQube is used before deployment

Static analysis is performed before deployment because it catches bugs, vulnerabilities, code smells, and technical debt earlier in the software delivery lifecycle. This prevents poor-quality code from being packaged into a container and promoted into more sensitive environments.

## Quality gate rules

A typical enterprise gate includes:
- no new blocker or critical issues
- coverage above a defined threshold
- no new security hotspots
- no code smells that block release quality

## Senior interview explanation

When the quality gate fails, the pipeline is intentionally stopped. The release is not promoted because the organization is protecting the release train from unstable code. The failure is treated as a governance signal, not a build artifact to ignore.

## Example commands

- `mvn test`
- `mvn sonar:sonar -Dsonar.projectKey=enterprise-sethu -Dsonar.host.url=http://localhost:9000`
- `curl -s http://localhost:9000/api/qualitygates/project_status?projectKey=enterprise-sethu`

## Project note

SonarQube is a quality gate that validates code before the artifact is containerized, scanned, and promoted.
