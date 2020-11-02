var express = require('express');
var app = express.Router();

const { check, query } = require('express-validator');
const { validate } = require('../server/middleware/validateMiddleware');

const UserController = require('../controller/userController');

const { authenticateAdmin } = require('../server/middleware/authenticateMiddleware');
const { returnResponse, formatResponse } = require("../server/middleware/responseMiddleware");

//==============================================================================

app.get('/', (req, res) => {
    returnResponse(res, formatResponse(200, null, "You are in the Auth Endpoint. Register or Login to test Authentication."));
});

//==============================================================================

module.exports = app;