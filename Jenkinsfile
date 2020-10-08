pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo "test"
                sh "chmod 755 gradlew"
                sh "ls -lart"
            }
        }
        stage('Test') {
            steps {
                gradlew 'test'
            }
        }
    }
}

def gradlew( task , boolean exitOnFailure=true ) {
    List<String> cmd = ["./gradlew -i -s"]

    cmd += task
    def exitCode = sh(
        script: cmd.join(' '),
        returnStatus: true)

    if (exitCode != 0) {
        if (exitOnFailure) {
            error "Failure to run task ${task}, exit code was ${exitCode}"
        } else {
            println "Ignoring failure on task ${task}, exit code was ${exitCode}"
        }
    }
    return exitCode

}