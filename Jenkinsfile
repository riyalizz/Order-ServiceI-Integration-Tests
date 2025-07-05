pipeline {
    agent any
  
    environment {
        PATH = "/usr/local/bin:$PATH"
    }
  
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run tests') {
            steps {
                sh '''
                    docker run -it \
                    -v "$(pwd)":/orderservicetest \
                    -v "$(pwd)/target":/orderservicetest/target \
                    4e698472485b
                '''
            }
        }
    }
}
