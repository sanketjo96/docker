Assignment
-----------------------------------------------------

Step 1. Pull following repositories

Product Service

git clone https://Dipurane@bitbucket.org/dipeshinnovation/product-service.git

User Service

git clone https://Dipurane@bitbucket.org/dipeshinnovation/user-service.git

Review Service

git clone https://Dipurane@bitbucket.org/dipeshinnovation/review-service.git

Step 2 Crate the docker images for services pulled in #1

For your convinience I have already added docker file in source code it self just build docker image using it. 

Step 3 Create a own bridge network

docker network create --driver bridge starlink

Step 4 Run All containers in bridge network


Run DB Containers with following commands

User Service

docker run -d -p 3307:3306 -e MYSQL_USER=docker -e MYSQL_PASSWORD=training -e MYSQL_ROOT_PASSWORD=training -e MYSQL_DATABASE=user-service --name user-db --network starlink mysql:5.5



Product Service

docker run -d -p 3308:3306 -e MYSQL_USER=docker -e MYSQL_PASSWORD=training -e MYSQL_ROOT_PASSWORD=training  -e MYSQL_DATABASE=product-service --name product-db --network starlink mysql:5.5


Review Service

docker run -d -p 3309:3306 -e MYSQL_USER=docker -e MYSQL_PASSWORD=training -e MYSQL_ROOT_PASSWORD=training -e MYSQL_DATABASE=review-service --name review-db --network starlink mysql:5.5

Run Service Containers with following commands

docker run -d -p 9000:9000 --network starlink --name user-service <your user service image name>

docker run -d -p 9001:9001 --network starlink --name product-service <your product service image name>

docker run -d -p 9002:9002 --network starlink --name review-service <your review service image name>


Step 5 Test your services

you can test all services on your machine at

Product service 
http://localhost:9001/swagger-ui.html

Review Service
http://localhost:9002/swagger-ui.html

User Service
http://localhost:9000/swagger-ui.html

Step 6 Push your docker images to docker hub

Put your docker images to respective reposiories create 3 repos for 3 services
user-service,product-service,review-service