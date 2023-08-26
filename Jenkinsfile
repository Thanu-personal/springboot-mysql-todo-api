pipeline {
    agent any

    stages {
        stage('checkout') {
            steps {
                echo 'Checking out code from github'
                git(url: 'https://github.com/Thanu-personal/springboot-mysql-todo-api.git', branch: 'helm_impl')
                sh """
                helm install mytodoapiapp ./helm_todo_h2
                """
            }
        }
    }
}