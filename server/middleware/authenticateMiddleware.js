// This middleware is used to authenticate the users request.
// Using passport.authenticate() and specifying the 'jwt' strategy,
// the request is authenticated by checking for the standard Authorization
// header and verifying the verification token, if any.
// If unable to authenticate request, an error message is returned.

const passport = require('passport');

module.exports = {
}
