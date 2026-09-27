# Git Workflow for Enterprise Sethu

## Branch strategy

- main: production-ready code
- develop: integration branch
- feature/*: feature work
- release/*: release preparation and hardening
- hotfix/*: urgent fixes for production

## Common commands

- `git clone <repo-url>`
- `git checkout -b feature/customer-api`
- `git status`
- `git add .`
- `git commit -m "Add customer API"`
- `git push origin feature/customer-api`
- `git merge develop`
- `git rebase develop`
- `git cherry-pick <commit-sha>`
- `git stash`
- `git reset --hard HEAD~1`
- `git revert <commit-sha>`
- `git tag -a v1.0.0 -m "Release 1.0.0"`

## Key interview points

- Merge creates a merge commit and preserves branch history.
- Rebase rewrites commit history and is useful when keeping a feature branch linear.
- Revert is safe for shared history; reset is destructive and should be used carefully.
- Cherry-pick allows a single fix from one branch to another.
- Release branches isolate stabilization while feature work continues.
- Hotfix branches are used for urgent production remediation.

## Project note

This repository will use a professional Git flow aligned with enterprise delivery practices.
