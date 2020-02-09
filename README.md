# docker
- DAY 1

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

- DAY 3
    - Vol mapping -
    - Optimization base - use source image wisely
    - Multilayer docker file
    - Discussed about java image and created a multilayer image

- DAY 4
    - Running containers quickly is the key in docker area
    - Tricks to optimize docker images
        - Use parent smarty, so that you can build and run things quickly 
        - Try to write multilayer files, where final image includes only source code
        - Each line maps to a layer of docker image, if docker detects the change at any layer it rebuilds layers subsequent of that. Try to have layer which are changing frequently at end. For example - copying source code
        - Try to reduce layers
            - NOT SO GOOD
                - do abc
                - do xyz
                - do mwc
            - Reduce layers (may be for unix based images)
                - do abc && do xyz && do mwc

    - Compressing image in one layer so that you can make that as a parent
        - Normally every line in dock image contributes to new layer
            - You can see all the layers after building image by writing - docker image history <image id>
        - We can reduce image to single layer to ship it as a single layer (most of the docker images on docker hub are in these class). Following cmd
            - 

