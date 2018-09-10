# Software Development Engineer in Test interviewer notes

There are two parts to the technical test: coding and testing.

## Coding assessment

*This should take up to 30 minutes.*

See [CODING_TESTS](CODING_TESTS.md)

## Testing assessment

*This should take up to 1 hour.*

This is a basic web service exposing several REST endpoints, which can be used to assess a candidate's ability to programatically test web services.

Instructions for the candidate are [here](INSTRUCTIONS.md).

The service is designed to simulate an eventually consistent distributed system, with a pause between when a value is written to it, and when that value is available to be read. Make sure you familiarise yourself with how the app works in [app.js](app.js) before the interview.

As this is an assessment of black box testing, it is not intended that the candidate sees the source code. The app is built into a docker image, which is available on Docker Hub. To run the app, use `docker run -p 8080:8080 -d vcharge/node-web-app`. It will be available on http://localhost:8080. You can use a tool like Postman or curl to play with hitting the endpoints.

When you've finished, you can clear this up by running `docker ps`; `docker stop <image name>`; `docker images`; `docker rmi -f <image>`.

To make changes to the app, clone this repo and make the changes. When you're ready, run `npm install` from the root folder of the app. The app can then be run locally with `npm start`.

To build a new docker image, use `docker build -t vcharge/node-web-app .`.