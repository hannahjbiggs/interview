'use strict';

const express = require('express');
const app = express();
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));

const devices = new Map();

app.get('/devices', (req, res) => {
	res.status(200).json(mapToObj(devices));
});

app.put('/devices', (req, res) => {
	const deviceId = req.body.id;
	
	if (devices.has(deviceId)) {
		res.status(400).json({
			error: 'Device already registered'
		});
	} else {
		devices.set(deviceId, "OFF");
		res.status(201).json({
			status: 'success',
			id: deviceId
		});
	}
});

app.post('/devices/:id', (req, res) => {
	const deviceId = req.params.id;
	const state = req.body.state;

	if (!devices.has(deviceId)) {
		res.status(400).json({
			error: 'Device ' + deviceId + ' not registered'
		});
	} else {
		setTimeout(setDeviceState, 5000, deviceId, state);
		res.status(201).json({
			status: 'success',
			id: deviceId
		});
	}
});

app.delete('/devices', (req, res) => {
	devices.clear();
	res.status(200).json({status: 'success'});
});

function setDeviceState(deviceId, state) {
	console.log('setting device state to ' + state);
	devices.set(deviceId, state);
}

function mapToObj(m) {
	let obj = Object.create(null);
	
	for (let [k, v] of m) {
		obj[k] = v;
	}
	return obj;
}


if (module === require.main) {
	const server = app.listen(process.env.PORT || 8080, () => {
		const port = server.address().port;
		console.log(`App listening on port ${port}`);
	});
}

module.exports = app;