pipeline {
    agent any
    properties([
        parameters([
            choice(name: 'BRANCH_NAME',choices: ['master','feature'], description:'Name of branch'),
            string(
                defaultValue: 'feature',
                name: 'branchName'
            )
        ])
    ])
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
