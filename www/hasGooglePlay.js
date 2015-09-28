var exec = require('cordova/exec');

module.exports = function hasStatusBar(callback) {
  return exec(callback, function (err) {
    callback(undefined, err);
  }, "HasGooglePlay", "hasGooglePlay", []);
};
