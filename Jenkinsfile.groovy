pipeline{
	agent any

	stages{

	   stage('Run tests'){
	      steps{
	      	  sh "docker-compose up"
	      }

	   }
	   stage('Put Selenium Grid down'){
	   	  
	      steps{
	      	  sh "docker-compose down"
	      }
	   }
	}
}