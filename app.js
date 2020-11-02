var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var cors = require('cors')
const bodyParser = require('body-parser');
const passport = require("passport");
const swaggerJsdoc = require('swagger-jsdoc');
const swaggerUi = require('swagger-ui-express');

//Create express object
var app = express();

//============================================================================
//CORS
app.use(cors());

//==============================================================================

//Require `config` and `db` files
require('./environment_config');
require('./server/db/mongoose').mongoose;
//We use this file just to get the basic public details of the app. All the secure things are stored in .env file
// config variables
const config = require('./config/config.js');

//===============================================================================

//Initialize and set up passport library
app.use(passport.initialize());
require('./server/middleware/jwtMiddleware')(passport);

//===============================================================================

app.use(bodyParser.urlencoded({ extended: true }));
// parse requests of content-type - application/json
app.use(bodyParser.json())
app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));
app.disable('x-powered-by');

//===============================================================================

// error handler
app.use(function (err, req, res, next) {
    // set locals, only providing error in development
    res.locals.message = err.message;
    res.locals.error = req.app.get('env') === 'development' ? err : {};

    // render the error page
    res.status(err.status || 500);
    res.render('error');
});

//===============================================================================

//Setup Swagger
const swaggerSetup = require('./swaggerSetup');
const specs = swaggerJsdoc(swaggerSetup.options);
app.use("/v1", swaggerUi.serve);
app.get(
    "/v1",
    swaggerUi.setup(specs, {
        explorer: true
    })
);

//===============================================================================

//disabling console logs in production
if (process.env.NODE_ENV != 'development' && process.env.NODE_ENV != 'testing')
    console.log = function () { };

//===============================================================================
//Require all the routes
const authRoutes = require('./routes/authRoutes');

app.use('/', authRoutes);

module.exports = app;