pipeline {
    agent any
    stages {
        stage('Build') {
            matrix {
                axes {
                    axis {
                        name 'OS'
                        values 'linux', 'windows'
                    }
                    axis {
                        name 'VERSION'
                        values '1.0', '2.0'
                    }
                }
                stages {
                    stage('Build') {
                        steps {
                            echo "Building on ${OS} version ${VERSION}"
                        }
                    }
                }
            }
        }
    }
}
