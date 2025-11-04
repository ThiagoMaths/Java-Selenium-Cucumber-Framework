pipeline {

    agent {
        dockerContainer {
            image 'markhobson/maven-chrome:jdk-21'
        args '-u root --shm-size=2g'
        }
    }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome'], description: 'Which browser to run the tests on?') // Deixei só 'chrome' por agora
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

                echo "Starting tests on ${params.BROWSER} (Headless: ${params.IS_HEADLESS})..."


                sh "cd TutorialsNinja && mvn clean test -Dbrowser.type=${params.BROWSER} -Dbrowser.headless=${params.IS_HEADLESS} -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer=warn"
            }
        }
    }

    post {
        always {
            echo "Generating Allure report..."
            allure commandline: 'Allure',
                   includeProperties: false,
                   reportBuildPolicy: 'ALWAYS',
                   results: [[path: 'TutorialsNinja/target/allure-results']]
        }
    }
}