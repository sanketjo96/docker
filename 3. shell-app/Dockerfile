# Need to create alpine image running shell script on run

FROM alpine
RUN mkdir /app

# Add's first arg is relative location
ADD test.sh /app/test.sh

# Creating a env variable to pass data from host to shell script
ENV USER_NAME=""

WORKDIR /app
RUN chmod 777 test.sh

# Run below after building
CMD [ "/bin/sh", "test.sh" ]