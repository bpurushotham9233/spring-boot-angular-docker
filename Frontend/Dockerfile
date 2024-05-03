FROM node:lts-alpine
# install dependencies first, in a different location for easier app bind mounting for local development
# due to default /home permissions we have to create the dir with root and change perms
RUN mkdir /home/app
WORKDIR /home/app
##RUN npm install -g @angular/cli
# the official node image provides an unprivileged user as a security best practice
# but we have to manually enable it. We put it here so npm installs dependencies as the same
# user who runs the app. 
# https://github.com/nodejs/docker-node/blob/master/docs/BestPractices.md#non-root-user
COPY package.json yarn.lock ./
ENV NODE_OPTIONS=--openssl-legacy-provider
ENV PATH /home/app/node_modules/.bin:$PATH
RUN yarn
# copy in our source code last, as it changes the most
EXPOSE 8082
##CMD [ "yarn", "start" ]
##COPY --chown=node:node . .
CMD ng serve --host 0.0.0.0

