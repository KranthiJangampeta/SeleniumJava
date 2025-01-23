pipeline {
    agent any

    tools {
        maven 'Maven 3.6.3'
    }

    parameters {
        string(name: 'JOB_TYPE', defaultValue: 'fit', description: 'Type of job to run (fit, iat, uat)')
    }

    matrix {
        axes {
            axis {
                name 'JOB_TYPE'
                values 'fit', 'iat', 'uat'
            }
        }

        stages {
            stage('Checkout') {
                steps {
                    git 'https://github.com/KranthiJangampeta/SeleniumJava.git'
                }
            }

            stage('Build') {
                steps {
                    sh 'mvn clean install'
                }
            }

            stage('Test') {
                steps {
                    sh 'mvn test'
                }
            }

            stage('Package') {
                steps {
                    sh 'mvn package'
                }
            }

            stage('Deploy') {
                when {
                    expression { env.JOB_TYPE == 'uat' }
                }
                steps {
                    sh 'scp target/your-app.jar user@server:/path/to/deploy'
                }
            }
        }

        post {
            always {
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            }
            success {
                mail to: 'you@example.com',
                     subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                     body: "The build was successful!"
            }
            failure {
                mail to: 'you@example.com',
                     subject: "FAILURE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                     body: "The build failed. Please check the Jenkins logs for more details."
            }
        }
    }
}