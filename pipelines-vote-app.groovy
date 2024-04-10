pipeline {
    agent any
    
    stages {
        stage('Clone Repo') {
            steps {
                echo "Checkout in progress "
                echo params.BRANCH_NAME
                git branch: "main" , url: "https://github.com/ansarizia/pipelines-vote-ui.git"
            }
        }
        
    }
}
