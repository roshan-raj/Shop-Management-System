// This middleware is used to authenticate the users request.
// Using passport.authenticate() and specifying the 'jwt' strategy,
// the request is authenticated by checking for the standard Authorization
// header and verifying the verification token, if any.
// If unable to authenticate request, an error message is returned.

const passport = require('passport');
const { returnResponse, formatResponse } = require('./responseMiddleware');
const { rolesEnum } = require('../../utils/constantUtils');

let authenticateAdmin = (req, res, next) => {
    passport.authenticate('jwt', function (err, user, info) {
        if (err) return next(err);

        if (!user) return returnResponse(res, formatResponse(404, null, "User not avaialable"));

        let userTokenArray = req.headers.authorization.split(" ");
        let userToken = userTokenArray[1];
        let tokensInDB = user.tokens;
        const tokenFound = tokensInDB.some(tokenObj => tokenObj.token === userToken);

        if (!tokenFound) {
            return returnResponse(res, formatResponse(401, null, "User is Logged Out"));
        }

        if (user.roleid.includes(rolesEnum.ADMIN)) {
            req.user = user;
            next();
        } else {
            return returnResponse(res, formatResponse(401, null, "Unauthorized access, Only Admin can access this!"));
        }
    })(req, res, next);
}

let authenticateShopOwner = (req, res, next) => {
    passport.authenticate('jwt', function (err, user, info) {
        if (err) return next(err);

        if (!user) return returnResponse(res, formatResponse(404, null, "User not avaialable"));

        let userTokenArray = req.headers.authorization.split(" ");
        let userToken = userTokenArray[1];
        let tokensInDB = user.tokens;
        const tokenFound = tokensInDB.some(tokenObj => tokenObj.token === userToken);

        if (!tokenFound) {
            return returnResponse(res, formatResponse(401, null, "User is Logged Out"));
        }

        if (user.roleid.includes(rolesEnum.ADMIN) || user.roleid.includes(rolesEnum.SHOPOWNER)) {
            req.user = user;
            next();
        } else {
            return returnResponse(res, formatResponse(401, null, "Unauthorized access, Only ShopOwner can access this!"));
        }
    })(req, res, next);
}

module.exports = {
    authenticateAdmin,
    authenticateShopOwner
}