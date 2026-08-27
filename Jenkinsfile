pipeline {

    agent { label 'jenkins-slave' }

    stages {

        stage('Checkout') {
            steps {
                echo '===== CHECKOUT ====='

                git branch: 'master',
                    url: 'https://github.com/GayathriRai/Hotel-Booking.git'
            }
        } 
 
     
        stage('Build') {
            steps {
                echo '===== BUILD ====='

                sh '''
                    export JAVA_HOME=/usr/lib/jvm/java-21-amazon-corretto.x86_64
                    export PATH=$JAVA_HOME/bin:$PATH

                    echo "JAVA_HOME=$JAVA_HOME"

                    java --version
                    javac -version
                    mvn -version

                    mvn clean compile
                '''
            }
        }

        stage('Test') {
            steps {
                echo '===== TEST ====='

                sh '''
                    export JAVA_HOME=/usr/lib/jvm/java-21-amazon-corretto.x86_64
                    export PATH=$JAVA_HOME/bin:$PATH

                    mvn test
                '''
            }

            post {
                always {
                    junit allowEmptyResults: true,
                          testResults: 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo '===== DEPLOY ====='

                sh '''
                    export JAVA_HOME=/usr/lib/jvm/java-21-amazon-corretto.x86_64
                    export PATH=$JAVA_HOME/bin:$PATH

                    echo "Building WAR..."

                    mvn package -DskipTests

                    echo "Checking WAR..."

                    ls -lh target/

                    test -f target/HotelBooking-1.0.war

                    echo "Deploying WAR..."

                    sudo cp target/HotelBooking-1.0.war \
                    /home/ec2-user/apache-tomcat-10.1.57/webapps/

                    echo "WAR deployed successfully."

                    ls -lh \
                    /home/ec2-user/apache-tomcat-10.1.57/webapps/HotelBooking-1.0.war
                '''
            }
        }
    }

    post {

        success {
            echo '======================================'
            echo 'BUILD → TEST → DEPLOY SUCCESSFUL'
            echo '======================================'
        }

        failure {
            echo '======================================'
            echo 'BUILD → TEST → DEPLOY FAILED'
            echo '======================================'
        }

        always {
            archiveArtifacts artifacts: 'target/HotelBooking-1.0.war',
                             allowEmptyArchive: true,
                             fingerprint: true
        }
    }
}
