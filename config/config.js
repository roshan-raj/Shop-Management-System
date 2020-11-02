//We are not using this file and all the required files from this. Since, we are using `dotenv` library
//All the required key values are stored in `.env` files

const _ = require('lodash');

// module variables
const config = require('./config.json');
const defaultConfig = config.development;
const environment = process.env.NODE_ENV || 'development';
const environmentConfig = config[environment];
const finalConfig = _.merge(defaultConfig, environmentConfig);
// as a best practice
// all global variables should be referenced via global. syntax
// and their names should always begin with g
global.gConfig = finalConfig;

module.exports={
    "use_database"          :      false,
    "host"                  :     "localhost",
    "username"              :     "root",
    "password"              :     "",
    "database"              :     "Database Name"
  }

// log global.gConfig
//console.log(`global.gConfig: ${JSON.stringify(global.gConfig, undefined, global.gConfig.json_indentation)}`);