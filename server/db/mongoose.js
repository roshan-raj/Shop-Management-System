const mongoose = require('mongoose');

mongoose.set('useNewUrlParser', true);
mongoose.set('useFindAndModify', false);

mongoose.connect(`${process.env.MONGO_URL_LOCAL}`, {
    useUnifiedTopology: true,
    useNewUrlParser: true
});

//Mongoose Events Which Will Keep Track Of Connection to DB
mongoose.connection.on('connected', function (res) {
    console.log("Successfully connected to the database");
});

mongoose.connection.on('error', function (error) {
    console.log('Could not connect to the database. ', error);
});

mongoose.connection.on('disconnected', function (disconnect) {
    console.log('Could Not Connect to the database. Disconnecting.....');
});

mongoose.Promise = global.Promise;

module.exports = {
    mongoose
};