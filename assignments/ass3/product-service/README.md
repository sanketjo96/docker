# Review-Service

# Steps to Complie & Create Image

docker build -t <your-image>:<your-tag> .

# Setup Database

docker run -d -p 3308:3306 -e MYSQL_USER=docker -e MYSQL_PASSWORD=training -e MYSQL_ROOT_PASSWORD=training  -e MYSQL_DATABASE=product-service --name product-db mysql:5.5

Note: Change connection string to while testing locally
   url : jdbc:mysql://localhost:3308/product-service

# Access Application

http://localhost:9001/swagger-ui.html