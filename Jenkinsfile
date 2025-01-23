pipeline {
    agent any
    parameters {
        // Add a parameter to specify which job to run (1, 2, or 3)
        choice(name: 'JOB_TO_RUN', choices: ['Job1', 'Job2', 'Job3'], description: 'Select which job to run')
    }
    stages {
        stage('Job 1') {
            when {
                expression { params.JOB_TO_RUN == 'Job1' }
            }
            steps {
                echo 'Running Job 1...'
                // Add your steps for Job 1 here
            }
        }

        stage('Job 2') {
            when {
                expression { params.JOB_TO_RUN == 'Job2' }
            }
            steps {
                echo 'Running Job 2...'
                // Add your steps for Job 2 here
            }
        }

        stage('Job 3') {
            when {
                expression { params.JOB_TO_RUN == 'Job3' }
            }
            steps {
                echo 'Running Job 3...'
                // Add your steps for Job 3 here
            }
        }
    }
}
