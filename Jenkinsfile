pipeline {
    agent any

    tools {
        // Install the Maven version configured in Jenkins
        maven 'Maven 3.6.3'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git 'https://github.com/KranthiJangampeta/SeleniumJava.git'
            }
        }

        stage('Build') {
            steps {
                // Run Maven build
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run Maven tests
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Package the application
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the application (this is just an example, adjust as needed)
                sh 'scp target/your-app.jar user@server:/path/to/deploy'
            }
        }
    }

    post {
        always {
            // Archive the build artifacts
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
        }
        success {
            // Notify success (this is just an example, adjust as needed)
            mail to: 'you@example.com',
                 subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                 body: "The build was successful!"
        }
        failure {
            // Notify failure (this is just an example, adjust as needed)
            mail to: 'you@example.com',
                 subject: "FAILURE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                 body: "The build failed. Please check the Jenkins logs for more details."
        }
    }
}