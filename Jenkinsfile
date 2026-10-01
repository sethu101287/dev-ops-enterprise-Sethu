pipeline {
    agent any

    parameters {
        choice(
            name: 'ENVIRONMENT',
            choices: ['DEV', 'QA', 'STAGE', 'PROD'],
            description: 'Target deployment environment'
        )
        string(
            name: 'VERSION',
            defaultValue: '1.0.0-SNAPSHOT',
            trim: true,
            description: 'Application version to build and promote'
        )
        choice(
            name: 'DEPLOY_TYPE',
            choices: ['ROLLING', 'BLUE_GREEN', 'CANARY', 'NONE'],
            description: 'Deployment pattern for the target environment'
        )
    }

    environment {
        APP_NAME = 'enterprise-Sethu-app'
        GROUP_ID = 'com.enterprise.Sethu'
        JAVA_HOME = tool name: 'Temurin-25', type: 'jdk'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
        MAVEN_OPTS = '-Dmaven.repo.local=.m2/repository'
    }

    options {
        timestamps()
        timeout(time: 45, unit: 'MINUTES')
        ansiColor('xterm')
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out source for ${params.ENVIRONMENT} / ${params.VERSION}"
                git branch: 'main', url: 'https://github.com/your-org/dev-ops-enterprise-Sethu.git'
                sh 'git --no-pager status --short'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn -B clean compile -DskipTests'
            }
        }

        stage('Unit Test') {
            steps {
                sh 'mvn -B test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn -B package -DskipTests'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withCredentials([string(credentialsId: 'sonarqube-token', variable: 'SONAR_AUTH_TOKEN')]) {
                    withSonarQubeEnv('sonarqube') {
                        sh '''
                            mvn -B sonar:sonar \
                              -Dsonar.projectKey=enterprise-sethu \
                              -Dsonar.projectName="Enterprise Sethu Platform" \
                              -Dsonar.host.url=$SONAR_HOST_URL \
                              -Dsonar.login=$SONAR_AUTH_TOKEN
                        '''
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true, credentialsId: 'sonarqube-token'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t ${env.APP_NAME}:${params.VERSION} ."
            }
        }

        stage('Trivy Scan') {
            steps {
                sh "trivy image --severity CRITICAL,HIGH,MEDIUM --exit-code 1 ${env.APP_NAME}:${params.VERSION}"
            }
        }

        stage('Push to Registry') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'nexus-registry-creds', usernameVariable: 'NEXUS_USER', passwordVariable: 'NEXUS_PASSWORD')]) {
                    sh '''
                        echo "Pushing ${APP_NAME}:${VERSION} to the container registry"
                        echo "Use docker login and docker push here with credentials from Jenkins secret store"
                    '''
                }
            }
        }

        stage('Deploy') {
            when {
                expression { return params.ENVIRONMENT != 'PROD' || params.DEPLOY_TYPE != 'NONE' }
            }
            steps {
                echo "Deploying ${APP_NAME}:${params.VERSION} to ${params.ENVIRONMENT} using ${params.DEPLOY_TYPE} strategy"
                echo 'This stage is the handoff to Kubernetes, OpenShift, or middleware deployment automation.'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
            archiveArtifacts allowEmptyArchive: true, artifacts: 'target/*.jar', fingerprint: true
        }
        success {
            echo "CI pipeline succeeded for ${params.ENVIRONMENT} / ${params.VERSION}"
        }
        failure {
            echo "CI pipeline failed for ${params.ENVIRONMENT} / ${params.VERSION}"
        }
    }
}
