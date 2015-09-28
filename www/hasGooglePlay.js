var exec = require('cordova/exec');

module.exports = function hasStatusBar(callback) {
  return exec(function (has) {
    callback(has === "true");
  }, function (err) {
    callback(undefined, err);
  }, "HasGooglePlay", "hasGooglePlay", []);
};
