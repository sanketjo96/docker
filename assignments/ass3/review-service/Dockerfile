From gradle:jdk8 AS build
RUN mkdir -p /app/code
WORKDIR /app/code
COPY ./src /app/code/src
COPY build.gradle /app/code/
RUN gradle clean build -x test

## Layer 2 

FROM openjdk:8-jre-alpine  
RUN mkdir -p /app/build
WORKDIR /app/build
COPY --from=build /app/code/build/libs/*.jar /app/build
EXPOSE 9002
ENTRYPOINT ["java","-jar","/app/build/code-0.0.1-SNAPSHOT.jar"]  
