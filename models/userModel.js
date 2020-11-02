const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const { v4 } = require('uuid');

const UserSchema = mongoose.Schema({
    email: {
        type: String,
        unique: true,
        required: true,
        trim: true
    },

    userid: {
        type: String,
        unique: true,
        required: true,
        default: () => v4()
    },

    password: {
        type: String,
        required: true,
        max: 100
    },

    firstname: {
        type: String,
        max: 100,
        required: false
    },

    lastname: {
        type: String,
        max: 100,
        required: false
    },

    dob: {
        type: Date,
        required: false
    },

    roleid: {
        type: Number,
        required: true,
        //Todo Use constants file and require it here and change the role id to a constant
        default: 3
    },

    bio: {
        type: String,
        required: false
    },

    //profileImage is the image url of where the image is stored
    profileimage: {
        type: String,
        required: false
    },
    
    tokens: [
        {
            token: {
                type: String,
                required: false
            }
        }
    ],
});

//================================================================================================================

// used to hash the user’s password using the bcrypt package whenever a user is created
// or their password is changed before saving in the database.
UserSchema.pre('save', function (next) {
    const user = this;
    // console.log("from schem",user.password);
    if (!user.isModified('password')) return next();

    bcrypt.genSalt(10, function (err, salt) {
        if (err) return next(err);

        bcrypt.hash(user.password, salt, function (err, hash) {
            if (err) return next(err);

            user.password = hash;
            next();
        });
    });
});

// used to compare the password entered by the user during login to the user’s password
// currently in the database.
UserSchema.methods.comparePassword = function (password) {
    return bcrypt.compareSync(password, this.password);
};

// used to compare the password entered by the user during login to the user’s password
// currently in the database.
UserSchema.methods.comparePasswordWithoutHashing = function (password) {
    return password === this.firstTimePassword;
};

// used for creating the authentication tokens using the jwt package.
// This token will be returned to the user and will be required for accessing protected routes.
UserSchema.methods.generateJWT = function () {

    let payload = {
        id: this._id,
        email: this.email,
        userid: this.userid
    };

    // The token payload includes the user’s userid and email address
    // and is set to expire 60 days in the future.
    return jwt.sign(payload, process.env.JWT_SECRET, {
        expiresIn: '60d'
    });
};

module.exports = mongoose.model('User', UserSchema);