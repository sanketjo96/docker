# Notes docker
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
    - Lets try out DAY 3 container with single docker compose file
        - Adding from images
        - ENV variables
        - Volumes
        - PORTS
    - Checkout
        - DAY4/simple - docker-compose
        - DAY4/details - docker-compose (with mapped vols)

    - You can make services up selectively
        - docker-compose user-service (will run only user service)

    - However, docker-compose is useful if you need to spin the containers on single machine. But in production for large applications this will not be the case. so docker-compose + bridge network is not for cloud based architecture 


- Day 5
    - Creating of 3 ec2 instances - master, worker1 and worker2 along with docker
        - Docker install
            - sudo yum update -y
            - sudo yum install docker -y
            - sudo service docker status
    - Adding new security group with below ports and apply it on above instances
        - SSH - TCP 22 - To connect these instances
        - TCP port 2377 for cluster management communications
        - TCP and UDP port 7946 for communication among nodes
        - UDP port 4789 for overlay network traffic

    - Test
        - Can container of worker 1 communicate to container of worker 2
        - Both these container are in default bridge network of respective machine so cant be communicated
        - Ways
            - Open the required port of worker node in security group for public and access 
                - BAD as if worker1 want to talk to 80 port of worker 2 it has to go throgh DNS route so slow things
                - Security as you may not want to access node publicly 
            - Create a private network/clusters of node using master (i.e using swarm, rancher or kubernaties etc)

        - Docker swarm
            - On master 
                - docker swarm init --advertise-addr=<publi.ip.of-master>
            - Above commad gives cmd to run on slave
                - Example - docker swarm join --token <sometocker> 172.31.43.57:2377
            - On master 
                - sudo docker node ls. This will list cluster nodes
            - Now on workers node if you hit join command you can see new default overlay network (similar to default_bridge). But we need to create custom overlay network
            - Now on master - create an custom overlay network
                - sudo docker network create -d overlay --attachable starlink
                - sudo docker network ls should show you overlay network
            - Now on worker1 
                - if you create a container with starlink network it works (even though created at master)
                        - sudo docker run -it --name alpine1 --network starlink alpine /bin/sh
                - It also attaches this new container in that network.
                - This happened due to --attachable flag used during network creation at master

            - Now on worker2 - if you create a another container with same starlink network
                - sudo docker run -d --name my-nginx -p 8080:80 --network starlink nginx
                - You will able to reach this from worker1's container using just name. This is now exactly similar with what we did for container communication on single host

            - SO WITH CREATION OF SWARM NODES (WORKER) CONTAINERS CAN TALK TO EACH OTHER ACROSS HOSTS WITHOUT OPENING SPECIFIC CONTAINERS PORTS IN FIREWALL

        - Rancher
            - Need to install rancher server i.e. rancher container
            - Rancher provides UI and role based access to it. it also saves applied conf if needed
            - To do all this it uses DB which needs to be mapped with the host machine
            - Create dir at master to take this data backup (we will connect this to container as a volume)
            - CMD
                - sudo docker run -d -v <host dir path fir backup>:/var/lib/mysql --restart=unless-stopped -p 8080:8080 rancher/server

            - Once image is ready > Should able to access ui at <master:public:ip>:8080
                - Set the username password for local use
            - You can deploy docker compose on rancher such way that you can scale as needed (refer VDO)

- Day 6
    - Deploy project across multiple nodes using rancher ui
    - Try to scale and the problem with the scaling with mapped ports
    - Removing mapping ports can provide you infinite scaling but then how to access the service from outside if mapped ports are not available. Here comes role of load balancer, which can provide single endpoint over scaled services
    - Ability to control which service should deployed on which node using labels inside compose file




 