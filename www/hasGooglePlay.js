var exec = require('cordova/exec');

// prime it
exec(function (res) {
	if (typeof res == 'object') {
		if (res.type == 'tap') {
			cordova.fireWindowEvent('statusTap');
		}
	} else {
		StatusBar.isVisible = res;
	}
}, null, "StatusBar", "_ready", []);

module.exports = function hasStatusBar(callback) {
	return exec(callback, function (err) {
		callback(err);
	}, "HasGooglePlay", "hasGooglePlay", []);
};
