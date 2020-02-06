# Try out Running multilayer docker build to create docker image for your java application.

# 1. Observe Dockerfile all multilayer code is commented.
# 2. Build using existing content observe the image size.
# 3. comments in docker file starts with #
# 4. Build after removing comments from all lines after section # Second layer in Dockerfile observe the image size.
# 5. Expose port 5050 & map it to port 4444 on your local host.
# 6. Push your docker image to dockerhub.



From gradle:jdk8 AS dipesh
RUN mkdir -p /app/code
WORKDIR /app/code
COPY ./code /app/code
RUN gradle clean build

# Second layer

FROM openjdk:8-jre-alpine  
RUN mkdir -p /app/build
WORKDIR /app/build
COPY --from=dipesh /app/code/build/libs/*.jar /app/build
EXPOSE 5050
ENTRYPOINT ["java","-jar","/app/build/code-0.0.1-SNAPSHOT.jar"]  
