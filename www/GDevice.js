var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'GDevice', 'coolMethod', [arg0]);
};
