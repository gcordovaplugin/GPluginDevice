var exec = require("cordova/exec");

exports.getDevice = function (success, error) {
  exec(success, error, "GDevice", "", [""]);
};
