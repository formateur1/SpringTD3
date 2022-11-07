pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Clean') {
            steps {
                
                bat "rmdir SpringTD3 /s /q"
                
                bat "git clone https://github.com/formateur1/SpringTD3.git"

                dir('SpringTD3') {
                    bat "mvn clean"
                }
                
            }
        }
        
        
    }
    
    post {
        always {  
             echo 'This will always run'  
         }  
         success {  
             echo 'This will run only if successful'  
         }  
         failure {  
            echo 'This will run only if failure'
         }  
         unstable {  
             echo 'This will run only if the run was marked as unstable'  
         }  
         changed {  
             echo 'This will run only if the state of the Pipeline has changed'  
             echo 'For example, if the Pipeline was previously failing but is now successful'  
         }  
    }
}
