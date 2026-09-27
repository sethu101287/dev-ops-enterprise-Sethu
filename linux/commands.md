# Linux Commands for Enterprise Sethu

## Filesystem

### ls
- What it does: Lists files and directories.
- Project usage: Verifies application files and deployment artifacts.
- Interview explanation: Shows basic host navigation and operational awareness.
- Example: `ls -lah`
- Troubleshooting: `ls -l /opt/enterprise-sethu`

### pwd
- What it does: Prints current working directory.
- Project usage: Confirms deployment path.
- Interview explanation: Validates execution context in scripts and pipelines.
- Example: `pwd`
- Troubleshooting: `pwd && ls -l`

### find
- What it does: Searches directories in a targeted manner.
- Project usage: Finds logs, JARs, and config files.
- Interview explanation: Essential in incident response and build artifact inspection.
- Example: `find /opt -name "*.jar"`
- Troubleshooting: `find /var/log -name "enterprise*" -type f`

### du
- What it does: Shows disk usage.
- Project usage: Validates container and volume size.
- Interview explanation: Helps in capacity and cleanup investigations.
- Example: `du -sh /var/lib/postgresql`
- Troubleshooting: `du -sh /var/log/*`

### df
- What it does: Displays disk filesystem usage.
- Project usage: Checks for root or volume saturation.
- Interview explanation: Common for troubleshooting disk-full incidents.
- Example: `df -h`
- Troubleshooting: `df -h / /var`

### chmod / chown
- What it does: Changes permissions and ownership.
- Project usage: Corrects application file and script permissions.
- Interview explanation: Demonstrates operating-system security awareness.
- Example: `chmod 750 scripts/*.sh` and `chown appuser:appgroup /opt/app`
- Troubleshooting: `ls -l` followed by `chmod +x build.sh`

## Processes

### ps / top
- What it does: Shows running processes and resource usage.
- Project usage: Confirms app, Jenkins, Java, and DB processes.
- Interview explanation: Critical during incidents and platform support.
- Example: `ps -ef | grep java`
- Troubleshooting: `top -H -p $(pgrep -f enterprise-Sethu-app)`

### kill / pkill
- What it does: Stops processes by PID or pattern.
- Project usage: Terminates hung Java processes or stale automation tasks.
- Interview explanation: Used in production recovery and controlled restarts.
- Example: `kill -9 1234`
- Troubleshooting: `pkill -f enterprise-Sethu-app`

## Network

### ss / netstat / curl
- What it does: Shows sockets and checks network connectivity.
- Project usage: Validates port exposure, service reachability, and app health.
- Interview explanation: Essential in troubleshooting DB, service, and ingress issues.
- Example: `ss -lntp | grep 8080` and `curl -I http://localhost:8080/api/health`
- Troubleshooting: `curl -v http://svc:8080/api/health`

## Logs

### tail / grep / awk / sed
- What it does: Reads and filters logs.
- Project usage: Investigates app startup, DB errors, and deployment issues.
- Interview explanation: Most incidents are diagnosed through log correlation.
- Example: `tail -f /var/log/app.log | grep -i error`
- Troubleshooting: `grep -i "database" /var/log/app.log | tail -50`

## Command reference

This is a starter Linux playbook for the project. It will be expanded with more incident-specific validation steps as the environment grows.
