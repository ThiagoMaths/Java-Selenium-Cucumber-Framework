pipeline {
    agent {
		dockerContainer {
			image 'maven:3.9-eclipse-temurin-21'
			args '-u root --shm-size=2g'
        }
    }

    parameters {
		choice(name: 'BROWSER', choices: ['chrome'], description: 'Which browser to run the tests on?')
        booleanParam(name: 'IS_HEADLESS', defaultValue: true, description: 'Run in headless mode (no UI)?')
    }

    stages {
        stage('Install Google Chrome') {
			steps {
				echo "Updating apt-get and installing dependencies..."
                sh "apt-get update -y && apt-get install -y wget"
                echo "Installing Google Chrome..."
                sh "wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -"
                sh "sh -c 'echo \"deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main\" >> /etc/apt/sources.list.d/google-chrome.list'"
                sh "apt-get update -y && apt-get install -y google-chrome-stable"
                echo "Google Chrome installation complete."
            }
        }

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