#! /bin/bash
CONTAINTER_NAME="stat-container"
IMAGE_NAME="stat-image"

echo "stop image..."
docker stop $CONTAINTER_NAME
docker rm $CONTAINTER_NAME
docker rmi $IMAGE_NAME

echo "Building image..."
docker build \
-t $IMAGE_NAME \
.

echo "Running image..."
docker run \
-d \
--name $CONTAINTER_NAME \
-p 8877:8080 \
$IMAGE_NAME