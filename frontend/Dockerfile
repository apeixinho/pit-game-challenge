FROM node:lts-alpine

ENV NODE_ENV=production

# Following best practices at:
# https://github.com/nodejs/docker-node/blob/master/docs/BestPractices.md


RUN apk update && apk upgrade && \
    apk add --no-cache build-base git && \
    rm -f /var/cache/apk/*

# ENV PATH=${PATH}:"$(yarn global bin)"

RUN addgroup -S app && adduser -S -g app app

COPY . /home/app/site

RUN chown -R app:app /home/app

USER app

WORKDIR /home/app/site

RUN yarn

# RUN yarn run build:prod

EXPOSE 8080

CMD yarn run start:prod
# CMD ["yarn", "run", "start:prod"]
# CMD ["tail","-f", "/dev/null"]
