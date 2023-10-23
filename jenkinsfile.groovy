pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Descarga de código desde el repositorio Git
                checkout scm
            }
        }
        
        stage('Pruebas de SAST') {
            steps {
                // Simulación de pruebas de calidad de código (SAST)
                echo "Ejecución de pruebas de SAST"
            }
        }
        
        stage('Build') {
            steps {
                // Construcción del contenedor Docker
                sh 'docker build -t devops_ws .'
            }
        }
    }
    
    post {
        success {
            // Captura de pantalla con los resultados de SonarQube
            // Puedes agregar aquí el paso para obtener y mostrar los resultados de SonarQube.
        }
    }
}
