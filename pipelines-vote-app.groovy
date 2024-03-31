pipeline {
    agent any

    stages {
        stage('Clone Repo') {
            steps {
                echo "Checkout in progress "
                git branch: "main" , url: "https://github.com/ansarizia/pipelines-vote-ui.git"
            }
        }
        stage('Docker Build') {
            steps{
            sh "docker build -t ansarizia/vote-ui:latest . "
            }
        }
        stage('Docker Push'){
            steps{
                
                withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId:'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                sh "docker login -u $USERNAME -p $PASSWORD"
                sh "docker push ansarizia/vote-ui:latest"
                }
            }
        }
        stage('Deploy'){
            steps{
                sh "kubectl apply -f k8s/deployment.yaml --kubeconfig /home/ziansari/.kube/config"
                sh "kubectl apply -f k8s/service.yaml --kubeconfig /home/ziansari/.kube/config"
            }
        }
    }
}
