pipeline {
    agent any
    stages {
        stage('PRIMEIRO PASSO') {
            steps {
                sh 'echo INICIANDO PIPELINE DO PROJETO'
                sh 'mvn clean package -DskipTests=true'
            }
        }
        stage('SEGUNDO PASSO') {
            steps {
                sh 'echo TESTES UNITARIOS'
                sh 'mvh test'
            }
        }
        stage('TERCEIRO PASSO') {
            steps {
                sh 'echo TESTES FUNCIONAIS'
            }
        }
        stage('QUARTO PASSO') {
            steps {
                sh 'echo ANALISE CODIGO'
            }
        }
        stage('QUINTO PASSO') {
            steps {
                sh 'echo DEPLOYS'
            }
        }
    }
}