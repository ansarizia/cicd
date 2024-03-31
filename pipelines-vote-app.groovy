pipeline {
    agent any

    stages {
        stage('Clone Repo') {
            steps {
                echo "Checkout in progress "
                git branch: "main" , url: "https://github.com/ansarizia/pipelines-vote-ui.git"
            }
        }
        
    }
}
