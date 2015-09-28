package org.apache.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

/**
* This class check if google play is installed
*/
public class HasGooglePlay extends CordovaPlugin {

  /**
  * Executes the request and returns PluginResult.
  *
  * @param action            The action to execute.
  * @param args              JSONArry of arguments for the plugin.
  * @param callbackContext   The callback id used when calling back into JavaScript.
  * @return                  True if the action was valid, false otherwise.
  */
  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if (action.equals("hasGooglePlay")) {

      // String message = args.getString(0);

      boolean hasGooglePlay = this.isGooglePlayInstalled();

      if(callbackContext != null) {
        callbackContext.success(hasGooglePlay);
      }

      return hasGooglePlay;
    } else {

      callbackContext.error("Unknown action.");
      return false;
    }
  }

  @JavascriptInterface
  public boolean isGooglePlayInstalled() {
    boolean googlePlayStoreInstalled;
    int val = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getapplicationcontext());
    googlePlayStoreInstalled = val == ConnectionResult.SUCCESS;
    return googlePlayStoreInstalled;
  }

  //another way to add a javascript interface
  // super.appView.addJavascriptInterface(new WebAppInterface(this), "jsInterface");
  // public class WebAppInterface {
  //   Context mContext;
  //   WebAppInterface(Context c) {
  //     mContext = c;
  //   }
  //   public boolean isGooglePlayInstalled() { .. }
  // }

}
