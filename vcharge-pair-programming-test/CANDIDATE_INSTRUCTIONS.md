# Pair Programming Test

We want to create a minimum viable application that can receive telemetry of the current National Grid frequency, and send alerts to IoT devices if the frequency is becoming unstable. We also need to be able to query the application to get the average frequency over the last x readings.

We don’t know how the telemetry will be sent to us yet (e.g. it could be REST, it could be from a Kafka topic etc), and we don’t have any devices to dispatch alerts to either, so we just need to build the core of the application. However, it should be built in an extensible way, so we can easily improve it later. **We’re looking for well structured and well tested code, but actually delivering a working product is the most important thing.**

The API should be as follows:
* A method to receive frequency telemetry, which will be a single floating point number (e.g. 50.1). If the current frequency and the previous frequency are either both above or both below 50, this signifies instability and would trigger the alert message to devices. For this exercise, the application should print “Alert” to the console instead.
* A method to request the average frequency over the past x readings, which will return a floating point number

To show that it is working, we need a demonstration of the application running as follows:
1. Send frequency of 50.0
2. Send frequency of 51.0
3. Send frequency of 52.0
4. —> “Alert” printed to the console
5. Send frequency of 49.0
6. Send frequency of 49.0
7. —> “Alert” printed to the console
8. Request average of last 4 readings
9. —> Receive answer of 50.25
