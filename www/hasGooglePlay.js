var exec = require('cordova/exec');

var HasGooglePlay = {
	hasGooglePlayServices: undefined,
	hasGooglePlayStore: undefined,
	check: function checkGooglePlay(callback) {
		HasGooglePlay.hasGooglePlayServices = undefined;
		HasGooglePlay.hasGooglePlayStore = undefined;

		exec(function (has) {
			HasGooglePlay.hasGooglePlayServices = (has === "true");
			if (typeof callback == 'function')
				callback(HasGooglePlay.hasGooglePlayServices);
		}, function (err) {
			if (typeof callback == 'function')
				callback(undefined, err);

			console.error(err);
		}, "HasGooglePlay", "hasGooglePlayServices", []);

		exec(function (has) {
			HasGooglePlay.hasGooglePlayStore = (has === "true");
			if (typeof callback == 'function')
				callback(HasGooglePlay.hasGooglePlayStore);
		}, function (err) {
			if (typeof callback == 'function')
				callback(undefined, err);

			console.error(err);
		}, "HasGooglePlay", "hasGooglePlayStore", []);

	}
};

HasGooglePlay.check();
module.exports = HasGooglePlay;
