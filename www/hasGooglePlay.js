var exec = require('cordova/exec');

var HasGooglePlay = {
  hasGooglePlayServices: undefined,
  hasGooglePlayStore: undefined,
  check: function checkGooglePlay(callback) {
    this.hasGooglePlayServices = undefined;
    this.hasGooglePlayStore = undefined;
    var that = this;

    exec(function (has) {
      that.hasGooglePlayServices = (has === "true");
      if (typeof callback == 'function')
        callback(that.hasGooglePlayServices);
    }, function (err) {
      if (typeof callback == 'function')
        callback(undefined, err);
    }, "HasGooglePlay", "hasGooglePlayServices", []);

    exec(function (has) {
      that.hasGooglePlayStore = (has === "true");
      if (typeof callback == 'function')
        callback(that.hasGooglePlayStore);
    }, function (err) {
      if (typeof callback == 'function')
        callback(undefined, err);
    }, "HasGooglePlay", "hasGooglePlayStore", []);

  }
};

HasGooglePlay.check();
module.exports = HasGooglePlay;
