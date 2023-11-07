pipeline {
    agent any

    stages {

        stage('Git Checkout') {
            steps {
                echo 'cloning project from GIT'
                git credentialsId: 'github-private-key', url: 'https://github.com/MolkaABID/DevProject.git'
             }
        }

         // stage('Backend') {
             //steps {
                // Étape de compilation du backend
               //  sh 'mvn clean package'
              //}
          //}
          stage('MVN CLEAN') {
            steps {
               sh 'mvn clean'
            }
        }
          stage('Test') {
            steps {
               sh 'mvn test'
            }
          }
          stage('MVN COMPILE') {
              steps {
                sh 'mvn compile'
               }
           }
        ///////////////////////////////////////
           /*
            stage('Integration testing') {
            steps {
                sh 'mvn verify -DskipUnitTestes'
                 }
            }*/

        /*stage('Frontend') {
            steps {
                // Étape de compilation du frontend
               // sh 'ng build'
            }
        }

        stage('Nexus') {
            steps {
                // Étape de déploiement du backend vers Nexus Repository Manager
                // Utilisez les configurations Nexus et Maven appropriées
            }
        }

        stage('Junit') {
            steps {
                // Étape de tests unitaires du backend
               sh 'mvn test'
            }
        }*/

        /*stage('SonarQube') {
            steps {
                // Étape d'analyse de qualité du code avec SonarQube
                // Utilisez la configuration SonarQube appropriée
            }
        }

        stage('Docker Image') {
            steps {
                // Étape de création d'images Docker pour le backend et le frontend
                // Utilisez les Dockerfiles appropriés
            }
        }

        stage('Docker Hub') {
            steps {
                // Étape de publication des images Docker sur Docker Hub
                // Utilisez les informations d'identification Docker Hub
            }
        }

        stage('Docker Compose') {
            steps {
                // Étape de déploiement avec Docker Compose
                // Utilisez un fichier Docker Compose pour spécifier les services et les configurations
            }
        }

        stage('Email') {
            steps {
                // Étape d'envoi de notifications par courrier électronique
                // Utilisez la configuration du serveur de messagerie et envoyez des e-mails
            }
        }

        stage('Grafana & Prometheus') {
            steps {
                // Étape de déploiement de Grafana et Prometheus
                // Utilisez les fichiers Docker Compose appropriés pour le déploiement
            }

    }


      post {
        always {
            emailext subject: 'Results for Jenkins',
                body: 'success.',
                to: 'molka.abid@esprit.tn',
                recipientProviders: [culprits(), developers(), brokenBuildSuspects()]
        }
      }*/

   }
}

