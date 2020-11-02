let returnResponse = (res, message) => {
    if (!message.statusCode)
        message = formatResponse(500, null, "Internal Server Error!");

    res.type('application/json');
    res.status(message.statusCode).send(JSON.stringify(message, null, 2));
};

let formatResponse = (statusCode, payload, message) => {
    return { "statusCode": statusCode, "body": payload, "message": message };
};

module.exports = {
    returnResponse,
    formatResponse
};