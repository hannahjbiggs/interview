# Software Development Engineer in Test technical test

## Candidate instructions

Our team have created a new RESTful web service, but it was a bit of a rush job and has no tests. However, it looks really promising and we're going to release it to production. The team would like to be able to rapidly iterate and release new features daily, so would like some automated tests to give them more confidence. Your job is to write those tests!

You can download and run the web service locally by using `docker run -p 8080:8080 -d vcharge/node-web-app`. The service should then be available on localhost:8080.

The team have documented the API as follows:

`GET /devices` returns a list of all registered devices and their states.

`PUT /devices` takes a body containing key = id, value = string
> curl -X PUT -d id=device1 localhost:8080/devices

`POST /devices/{id}` takes a body containing key = state, value = string
> curl -X POST -d state=STANDBY localhost:8080/devices/device1

`DELETE /devices` removes all devices.