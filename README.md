# Pit Game Challenge

Project implementation of challenge Pit Game

## Getting Started

Checkout/clone the project

### Prerequisites

- [Docker](https://www.docker.com/) and [docker-compose](https://docs.docker.com/compose/install/) if running with **Docker** ;)
- [NodeJS](https://nodejs.org/en/), [Yarn](https://yarnpkg.com/en/), [Java](https://www.java.com/en/), [Maven](https://maven.apache.org/) if running without **Docker**

## Building with Docker

To build with **docker-compose** issue the following command:

```
docker-compose build
```

Check the built images with the following command:

```
docker images
```

Check running containers with the following command:

```
docker ps
```

## Building without Docker

To build the frontend issue the following command:

```
yarn
```

To build the backend issue the following command:

```
mvn clean install
```

## Running with Docker

To run the projects, with docker, issue the following command:

```
docker-compose up -d
```

Point your browser to [localhost:8080](localhost:8080)

## Running without Docker

To run the backend project issue the following command:

```
mvn spring-boot:run
```

To run the frontend project issue the following command:

```
yarn run start        # to run in development mode
yarn run start:prod   # to run in production mode
```

Point your browser to [localhost:8080](localhost:8080)

## Pit Game Rules

### Board Setup

Each of the two players has his six pits in front of him. To the right of the six pits, each player has a larger pit. In each of the six round pits are put six stones when the game starts.

### Game Play

The player who begins with the first move picks up all the stones in anyone of his own six pits, and sows the stones on to the right, one in each of the following pits, including his own big pit. No stones are put in the opponents' big pit. If the player's last stone lands in his own big pit, he gets another turn. This can be repeated several times before it's the other player's turn.

### Capturing Stones

During the game the pits are emptied on both sides. Always when the last stone lands in an own empty pit, the player captures his own stone and all stones in the opposite pit (the other players' pit) and puts them in his own pit.

### The Game Ends

The game is over as soon as one of the sides run out of stones. The player who still has stones in his pits keeps them and puts them in his/hers big pit. Winner of the game is the player who has the most stones in his big pit.
