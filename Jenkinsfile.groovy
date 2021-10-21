#!/usr/bin/env groovy
pipeline {
    agent { node { label 'swarm-ci' } }

    stages {
        stage ('Scan and Build Jar File') {
            steps {
               withSonarQubeEnv(installationName: 'Production SonarQubeScanner', credentialsId: 'SonarQubeToken') {
                sh 'mvn clean package sonar:sonar'
                }
            }
        }
    }
}