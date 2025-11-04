pipeline {
    agent any
    tools {
        maven 'Maven 3.9.x'
        jdk 'JDK 21'
    }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'firefox'], description: 'Which browser to run the tests on?')
        booleanParam(name: 'IS_HEADLESS', defaultValue: true, description: 'Run in headless mode (no UI)?')
    }

    stages {
        stage('Checkout') {
            steps {
                cleanWs()
                checkout scm
                echo "Source code checked out successfully."
            }
        }

        stage('Build & Test') {
            steps {
                withEnv(["JAVA_HOME=${tool 'JDK 21'}", "PATH+MAVEN=${tool 'Maven 3.9.x'}/bin"]) {

                    echo "Starting tests on ${params.BROWSER} (Headless: ${params.IS_HEADLESS})..."

                    sh "cd TutorialsNinja && mvn clean test -Dbrowser.type=${params.BROWSER} -Dbrowser.headless=${params.IS_HEADLESS}"
                    }
                }
            }
        }
    }

    post {
        always {
            echo "Generating Allure report..."
            allure includeProperties: false,
                   jdk: 'JDK 21',
                   reportBuildPolicy: 'ALWAYS',
                   results: [[path: 'target/allure-results']]
        }
    }
}