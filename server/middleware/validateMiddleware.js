// This middleware is used to check if the express-validator middleware returns an error.
// If so, it recreates the error object using the param and msg keys and returns the error.
const { validationResult } = require('express-validator');
const { sendResponse, formatAndReturnResponse } = require('com.thbs.responsehelper');

let validate = (req, res, next) => {

    const errors = validationResult(req);
    if (!errors.isEmpty()) {
        let error = {};
        errors.array().map((err) => error[err.param] = err.msg);
        return returnResponse(res, formatResponse(400, null, error));
    }
    next();
};

module.exports = {
    validate
}
