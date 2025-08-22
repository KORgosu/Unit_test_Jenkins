pipeline {
    agent any

    // SonarQube 서버 정보와 인증키를 환경 변수로 설정합니다.
    environment {
        // Jenkins 관리 > 시스템 설정에 등록한 SonarQube 서버의 이름입니다.
        SONARQUBE_SERVER = 'sonarqube'
    }

    stages {
        stage('Permission') {
            steps {
                // gradlew 스크립트에 실행 권한을 부여합니다.
                sh 'chmod +x ./gradlew'
            }
        }

        stage('Build & Test') {
            steps {
                // 프로젝트를 빌드하고 테스트를 실행합니다.
                sh './gradlew build'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // 위에서 설정한 SonarQube 서버 환경을 불러와 분석을 실행합니다.
                // withSonarQubeEnv가 URL과 토큰을 자동으로 주입해주므로, gradlew 명령어는 간단하게 유지됩니다.
                withSonarQubeEnv(SONARQUBE_SERVER) {
                    sh './gradlew sonarqube'
                }
            }
        }
    }

    // 파이프라인이 끝난 후 SonarQube Quality Gate 결과를 확인합니다.
    post {
        success {
            // Quality Gate 결과를 기다리고, 통과하지 못하면 파이프라인을 실패 처리합니다.
            // 이 단계를 통해 코드 품질을 강제할 수 있습니다.
            waitForQualityGate abortPipeline: true
        }
    }
}