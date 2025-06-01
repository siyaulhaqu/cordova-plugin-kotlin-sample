var exec = require('cordova/exec');

var KotlinSample = {
    echo: function(message, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "KotlinSample", "echo", [message]);
    },
    getDate: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, "KotlinSample", "getDate", []);
    }
};

module.exports = KotlinSample;
