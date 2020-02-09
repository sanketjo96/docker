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

    - Creating an image in one layer so that it will get pulled faster if any one made it parent
        - Normally every line in dock image contributes to new layer
            - You can see all the layers after building image by writing - docker image history <image id>
        - We can reduce it and ship as a single layer (most of the docker images on docker hub are in these class).
        - Steps
            - Build some image
            - Run that image to form container
            - docker container ls
            - Spot the container id
            - docker export <container id> > <somename>.tar (Creating a single layer compressed file from container)
            - cat <somename>.tar | docker import -  <new name to image>
            - docker image -a (note the new image id)
            - docker image history <image id>
        - All above steps are not for compressing image but its for merging image to one layer so that pushing and pulling will be fast

    - Networking
        - Containers cant talk to each other by default
            - docker run -d -p 8080:80 ngnix
        - I am able to curl ngnix from laptop but can I do so from other container ?
            - docker run -it alpine /bin/sh

        - Networks - Bridge, Overlay
            - Bridge - Its restricted to machine on which you are running
                - docker network create --driver bridge starlink

            - Register above container for starlink network now
                - docker run -d -p 8080:80 --name my-nginx --network starlink nginx
                - docker container run -it --name alpine-sank --network starlink alpine /bin/sh
            - Communication should be possible with IP address now ? But ip can change then ? Docker lets you use name as well

- DAY 4
    - Maintaining multiple commands for multiple container is bit too much
    - Here comes docker compose. A tool for writing multiple container with single file
    - Its a YML file which maintains all configuration (essentially things from your COMMANDS)