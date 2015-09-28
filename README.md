# cordova-has-google-play

Has-Google-Play
======

> This plugin let your cordova javascript app to know if the Android device has google play installed.


## Installation

    cordova plugin add https://github.com/sauvainr/cordova-has-google-play

## Usage

The test is runned automatically at startup, so you can just ust:

    if(!window.HasGooglePlay.hasGooglePlayStore || !window.HasGooglePlay.hasGooglePlayServices){

      .. auto-update logic ..

    }

or

    window.HasGooglePlay.check(function (hasGooglePlay) {

      console.log(hasGooglePlay);

    });
