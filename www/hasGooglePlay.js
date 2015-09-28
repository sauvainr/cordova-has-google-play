var exec = require('cordova/exec');

var HasGooglePlay = {
  hasGooglePlayServices: undefined,
  hasGooglePlayStore: undefined,
  check: function checkGooglePlay(callback) {
    HasGooglePlay.hasGooglePlayServices = undefined;
    HasGooglePlay.hasGooglePlayStore = undefined;

    var count = 0;

    exec(function (has) {
      HasGooglePlay.hasGooglePlayServices = (has === "true");
      count++;
      if (count == 2 && typeof callback == 'function')
        callback(HasGooglePlay.hasGooglePlayServices);
    }, function (err) {
      count++;
      if (count == 2 && typeof callback == 'function')
        callback(undefined, err);

      console.error(err);
    }, "HasGooglePlay", "hasGooglePlayServices", []);

    exec(function (has) {
      count++;
      HasGooglePlay.hasGooglePlayStore = (has === "true");
      if (count == 2 && typeof callback == 'function')
        callback(HasGooglePlay.hasGooglePlayStore);
    }, function (err) {
      count++;
      if (count == 2 && typeof callback == 'function')
        callback(undefined, err);

      console.error(err);
    }, "HasGooglePlay", "hasGooglePlayStore", []);

  }
};

HasGooglePlay.check();
module.exports = HasGooglePlay;
