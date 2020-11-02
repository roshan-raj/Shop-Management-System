// This middleware is used to check if the express-validator middleware returns an error.
// If so, it recreates the error object using the param and msg keys and returns the error.