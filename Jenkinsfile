pipeline {
    agent any

    environment {
        GIT_URL = 'https://github.com/Annamalai-Raja/naukri-automation.git'
        BRANCH_NAME = 'master'
        EMAIL_RECIPIENTS = 'rna65260@gmail.com'
        REPORT_PATH = 'ExtentReports/**/*.zip'
    }

 stages {

         stage('Checkout Code') {
             steps {
                 echo 'Cloning the Git repository...'
                 git branch: env.BRANCH_NAME, url: env.GIT_URL
             }
         }

        stage('Build and Test') {

            steps {
                echo "Building and Running Tests..."
                catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                    bat 'mvn clean install'
                }
            }
        }

        stage('Archive Reports') {
            steps {
                echo 'Archiving test reports...'
                archiveArtifacts artifacts: env.REPORT_PATH, allowEmptyArchive: true
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully!'
            emailext(
                to: env.EMAIL_RECIPIENTS,
                subject: "Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                    Hi Team,

                    The build completed successfully.
                    Job: ${env.JOB_NAME}
                    Build Number: ${env.BUILD_NUMBER}
                    Git Branch: ${env.BRANCH_NAME}
                """,
                attachmentsPattern: env.REPORT_PATH // Attach the report file(s)
            )
        }

        failure {
            echo 'Build failed!'
            emailext(
                to: env.EMAIL_RECIPIENTS,
                subject: "Build Failure: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                    Hi Team,

                    The build failed.
                    Job: ${env.JOB_NAME}
                    Build Number: ${env.BUILD_NUMBER}
                    Git Branch: ${env.BRANCH_NAME}
                """,
                attachmentsPattern: env.REPORT_PATH // Attach the report file(s)
            )
        }
         always {
                    echo 'Cleaning up workspace...'
                    deleteDir()
                }
    }
}