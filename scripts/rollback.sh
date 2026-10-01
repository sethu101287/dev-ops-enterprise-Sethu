#!/bin/bash
set -euo pipefail

APP_NAME=${APP_NAME:-enterprise-Sethu-app}
PREVIOUS_VERSION=${PREVIOUS_VERSION:-1.0.0}
TARGET_ENV=${TARGET_ENV:-dev}

 echo "Rolling back ${APP_NAME} in ${TARGET_ENV} to ${PREVIOUS_VERSION}"
 echo "Production rollback should validate the previous known-good artifact and monitor health before resuming traffic."
