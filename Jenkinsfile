pipeline {
    agent any
    stages {
        stage('Permission') {
            steps {
                sh 'chmod +x ./gradlew'
            }
        }
        stage('Compile') {
            steps {
                sh './gradlew compileJava'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        // 필요에 따라 Build, Deploy 등의 Stage 추가
    }
}