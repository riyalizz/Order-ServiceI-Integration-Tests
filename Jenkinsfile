pipeline {
    agent any
  
    environment {
        PATH = "/usr/local/bin:$PATH"
    }
  
    stages {
        
        stage('Run tests') {
            steps {
                sh '''
                    docker run --rm \
                    -v "$(pwd)":/orderservicetest \
                    -v "$(pwd)/target":/orderservicetest/target \
                    4e698472485b
                '''
            }
        }
        
        stage('Publish TestNG Report') {
            steps {
                archiveArtifacts artifacts: 'target/surefire-reports/emailable-report.html'
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'emailable-report.html',
                    reportName: 'TestNG Emailable Report'
                    ])
            }
        }

          stage('Build Tests') {
            steps {
                 script {
                    // Groovy comment here is fine
                    def branch = env.BRANCH_NAME ?: sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
                    def sha = sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()

                    def dockerTag = "${branch}:${sha}"

                    echo "Building Docker image with tag: ${dockerTag}"

                    // Build docker image command
                    sh "docker build . -t order-service-integration-tests:${dockerTag}"
                }
            }
        }
    }
}
