# Review-Service

# Steps to Complie & Create Image

docker build -t <your-image>:<your-tag> .

# Setup Database

docker run -d -p 3309:3306 -e MYSQL_USER=docker -e MYSQL_PASSWORD=training -e MYSQL_ROOT_PASSWORD=training -e MYSQL_DATABASE=review-service --name review-db mysql:5.5

Note: Change connection string to while testing locally
   url : jdbc:mysql://localhost:3309/review-service

# Access Application

http://localhost:9002/swagger-ui.html