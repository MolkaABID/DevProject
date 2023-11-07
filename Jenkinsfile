pipeline {
    agent any

    stages {

        stage('Git Checkout') {
            steps {
                echo 'cloning project from GIT'
                git credentialsId: 'github-private-key', url: 'https://github.com/MolkaABID/DevProject.git'
             }
        }
/////////
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
               echo 'hana ntestiw'
               sh 'mvn test'
            }
          }
        stage('Integration testing') {
          steps {
            sh 'mvn verify -DskipUnitTestes'
                 }
            }
          stage('MVN COMPILE') {
              steps {
                sh 'mvn compile'
               }
           }

         stage('sonarqube') {
                 {

                     sh "mvn sonar:sonar \
                            -Dsonar.projectKey= \
                            -Dsonar.host.url=http://192.168.1.20:9000 "

                     }

         }
            /*sqa_d5029b69cf0ceef39d5a946d5cbcdb0319e7cd79*/
        ///////////////////////////////////////



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

        stage('Grafana & Prometheus') {
            steps {
                // Étape de déploiement de Grafana et Prometheus
                // Utilisez les fichiers Docker Compose appropriés pour le déploiement
            }

    }
      */


   }
   post {


       success {
           mail to: "molka.abid@esprit.tn",
           subject: "Success",
           body: "Success on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}"
       }
       failure {
           mail to: "molka.abid@esprit.tn",
           subject: "Failure",
           body: "Failure on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}"
       }
   }



}

