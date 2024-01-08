pipeline{
	agent any

	stages{
		stage('Start Grid'){
            steps{
                sh "docker-compose -f grid.yaml up -d"
            }
        }

	   stage('Run tests'){
	      steps{
	      	  sh "docker-compose -f test-suites.yaml up --pull=always"
	      }

	   }
	}
	post {
        always {
            sh "docker-compose -f grid.yaml down"
            sh "docker-compose -f test-suites.yaml down"
            archiveArtifacts artifacts: 'output/flight-reservation/emailable-report.html', followSymlinks: false
            archiveArtifacts artifacts: 'output/vendor-portal/emailable-report.html', followSymlinks: false
        }
    }
}