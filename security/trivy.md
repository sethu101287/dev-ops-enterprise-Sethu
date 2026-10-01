# Trivy Security Scanning for Enterprise Sethu

## Why Trivy is in the pipeline

Trivy is used to detect vulnerabilities in software dependencies, container images, and infrastructure configuration before an artifact is promoted. In an enterprise release flow, this is a control point that reduces the chance of shipping known CVEs into dev, QA, stage, or production.

## Scan types

- filesystem scan: checks dependency and source-level vulnerabilities
- image scan: inspects the built container image
- IaC scan: validates Kubernetes and infrastructure manifests

## Severity categories

- CRITICAL: immediate attention; production promotion should block or require explicit exception
- HIGH: should be reviewed quickly and often treated as release blockers depending on policy
- MEDIUM: triage and remediation planned based on risk posture
- LOW: monitor and remediate in regular maintenance windows

## Example commands

```bash
trivy fs --severity CRITICAL,HIGH .
trivy image --severity CRITICAL,HIGH enterprise-sethu-app:1.0.0
trivy config kubernetes/
```

## Interview answer

A senior DevOps or release engineer should explain that security scanning is done before deployment because it shortens the blast radius of vulnerable software, provides traceable evidence, and ensures that critical issues are caught before release windows, runtime onboarding, or customer-facing exposure.

## Project policy

Critical vulnerabilities should fail the production promotion process unless the release team formally accepts an exception and documents compensating controls.
