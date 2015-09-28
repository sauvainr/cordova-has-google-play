var exec = require('cordova/exec');

module.exports = {
  hasGooglePlay: undefined,
  check: function checkGooglePlay(callback) {
    this.hasGooglePlay = undefined;
    var that = this;

    exec(function (has) {
      that.hasGooglePlay = (has === "true");
      if (typeof callback == 'function')
        callback(that.hasGooglePlay);
    }, function (err) {
      if (typeof callback == 'function')
        callback(undefined, err);
    }, "HasGooglePlay", "hasGooglePlay", []);
  }
};

module.exports.check();
