# Need to express webserver container

FROM node:6.11.5
RUN mkdir /app

# Add's first arg is relative location
COPY app /app

WORKDIR /app

RUN npm install

EXPOSE 3000

# Run below after building
CMD [ "npm", "start" ]