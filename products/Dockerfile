FROM java:8-jre-alpine

ENV APP_PATH=/app

WORKDIR $APP_PATH

COPY build/libs/app.jar $APP_PATH/products.jar
COPY scripts/wait.sh wait.sh

ENTRYPOINT java -jar products.jar