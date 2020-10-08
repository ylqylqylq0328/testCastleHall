pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo "test"
            }
        }
        stage('Test') {
            steps {
                gradlew 'test'
            }
        }
    }
}