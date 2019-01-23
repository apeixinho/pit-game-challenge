# webpack-simple-example

Just a quick and dirty example on how Webpack is integrated into the project, and how to use without any frameworks or libraries.

This teaches you how to use Event Listeners in order for you to execute bundled
code with Wepback and Vanilla JavaScript.

This **doesn't** require a web server in order for you to view it. Just open [index.html](./index.html) and it works! (Of course, have at least [/dist/main.js](/dist/main.js) downloaded)

## Check:

- [index.js](./src/index.js)
- [index.html](./index.html)

### Other notes:

Just in case you want to make some changes, check the **npm scripts** in **package.json**.

- to build for development do: `npm run build` or `yarn run build`
- to build for production do: `npm run build:prod` or `yarn run build:prod`
- to start **webpack-dev-server** in **development mode** do: `npm run start` or `yarn run start`
- to start **webpack-dev-server** in **production mode** do: `npm run start:prod` or `yarn run start:prod`
