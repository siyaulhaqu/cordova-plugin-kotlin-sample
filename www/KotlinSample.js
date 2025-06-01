var exec = require('cordova/exec');

var KotlinSample = {
    echo: function(message, successCallback, errorCallback) {
        alert("before");
        exec(successCallback, errorCallback, "KotlinSample", "echo", [message]);
        alert("after");
    },
    getDate: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, "KotlinSample", "getDate", []);
    }
};

module.exports = KotlinSample;
