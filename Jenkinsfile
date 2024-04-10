pipeline {
    agent any

    stages {
        stage('Clone Repo') {
            steps {
                echo "Checkout in progress "
                echo "Branch Name"
                echo params.BRANCH_NAME
                println "Branch" + params.BRANCH_NAME
                git branch: params.BRANCH_NAME , url: "https://github.com/ansarizia/pipelines-vote-ui.git"
            }
        }
        
    }
}
