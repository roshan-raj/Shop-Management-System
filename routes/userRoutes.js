var express = require('express');
var app = express.Router();

const { check, query } = require('express-validator');
const { validate } = require('../server/middleware/validateMiddleware');

const UserController = require('../controller/userController');

const { authenticateAdmin } = require('../server/middleware/authenticateMiddleware');
const { sendResponse, formatAndReturnResponse } = require('com.thbs.responsehelper');

//==============================================================================

app.get('/', (req, res) => {
    sendResponse(res, formatAndReturnResponse(200, null, "You are in the Auth Endpoint. Register or Login to test Authentication."));
});

//==============================================================================

module.exports = app;