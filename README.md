# docker
- Day 2 
    - CMDs
        - docker ps - containers in running state
        - docker ps -a - all containers
        - docker run --name <your_name> <image-name>
        - docker run -it <image-name> /bin/sh
        - docker start <docker-id> (start stopped container)
        - docker exec -it <docker-id> (connect to running container)
        - docker build -t myapp . (Running docker file from same folder)

        - docker images

    - Docker hub maintains hash per image to identify images uniquely
