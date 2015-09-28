package org.apache.cordova.plugin;

import org.apache.cordova.*;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

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

  private static final String GooglePlayStorePackageName = "com.google.market";

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
    // String message = args.getString(0);

    if (action.equals("hasGooglePlayServices")) {

      boolean hasGooglePlay = this.isGooglePlayServicesInstalled();

      callbackContext.success(java.lang.Boolean.toString(hasGooglePlay));
      return true;
    } else if (action.equals("hasGooglePlayStore")) {

      boolean hasGooglePlayStore = this.isGooglePlayStoreInstalled();

      callbackContext.success(java.lang.Boolean.toString(hasGooglePlayStore));
      return true;
    } else {

      callbackContext.error("Unknown action.");
      return false;
    }
  }

  @JavascriptInterface
  public boolean isGooglePlayServicesInstalled() {
    Context context=this.cordova.getActivity().getApplicationContext();
    boolean googlePlayStoreInstalled;
    int val = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
    googlePlayStoreInstalled = val == ConnectionResult.SUCCESS;
    return googlePlayStoreInstalled;
  }

  @JavascriptInterface
  public boolean isGooglePlayStoreInstalled() {
    //note test old & new play sotre name
    return this.isPackageInstalled("com.google.market") || this.isPackageInstalled("com.android.vending");
  }

  // from http://stackoverflow.com/questions/10551531/cannot-determine-whether-google-play-store-is-installed-or-not-on-android-device
  protected final boolean isPackageInstalled(String packageName) {
    PackageManager packageManager = getApplication().getPackageManager();
    List<PackageInfo> packages = packageManager.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);

    for (PackageInfo packageInfo : packages) {
      if (packageInfo.packageName.equals(packageName)) {
        return true;
      }
    }

    return false;
  }

  //another way to add a javascript interface, not tested..
  // super.appView.addJavascriptInterface(new WebAppInterface(this), "jsInterface");
  // public class WebAppInterface {
  //   Context mContext;
  //   WebAppInterface(Context c) {
  //     mContext = c;
  //   }
  //   public boolean isGooglePlayInstalled() { .. }
  // }

}
