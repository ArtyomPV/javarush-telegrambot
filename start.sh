#!/bin/bash

# Pull new changes
git pull

# Prepare Jar


# Ensure, that docker-compose stopped
docker-compose stop

# Add environment variables
export BOT_TOKEN=$1

# Start new deployment
docker-compose up --build -d