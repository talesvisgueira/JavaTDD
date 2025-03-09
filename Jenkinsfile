pipeline {
    agent any
    stages {
        stage('BUILD DO PROJETO') {
            steps {
                sh 'echo INICIANDO PIPELINE DO PROJETO'
                sh 'mvn clean package -DskipTests=true'
            }
        }
        stage('TESTES UNITÁIROS') {
            steps {
                sh 'echo TESTES UNITARIOS'
                sh 'mvn test'
            }
        }
        stage('TESTES FUNCIONAIS') {
            steps {
                sh 'echo ANALISE CODIGO'
            }
        }
        stage('ANALISE CODIGO') {
            steps {
                sh 'echo ANALISE CODIGO'
            }
        }
        stage('DEPLOY') {
            steps {
                sh 'echo DEPLOY'
            }
        }
    }
}