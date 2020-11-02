// config.js
const dotenv = require('dotenv');

//get the NODE_ENV from the arguments set in the package.json file
const NODE_ENV = process.argv[2] || process.env.NODE_ENV;
process.env.NODE_ENV = NODE_ENV;

let result;

if (NODE_ENV == 'development')
    result = dotenv.config({ path: './.env.development' });

if (NODE_ENV == 'testing')
    result = dotenv.config({ path: './.env.testing' });

if (NODE_ENV == 'staging')
    result = dotenv.config({ path: './.env.staging' });

if (NODE_ENV == 'production')
    result = dotenv.config({ path: './.env.production' });

if (result.error) {
    throw result.error;
}
const { parsed: envs } = result;
module.exports = envs;