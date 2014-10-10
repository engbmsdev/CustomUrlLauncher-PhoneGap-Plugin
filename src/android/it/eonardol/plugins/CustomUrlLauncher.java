package it.eonardol.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.content.pm.PackageManager;

public class CustomUrlLauncher extends CordovaPlugin {
  private static final String ACTION_LAUNCH_EVENT = "launch";
  private static final String ACTION_CAN_LAUNCH_EVENT = "canLaunch";

  private static final String LOG_TAG = "CustomUrlLauncher";
  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if (ACTION_LAUNCH_EVENT.equals(action)) {
      final String urlToLaunch = args.getString(0);
      Log.i(LOG_TAG, "opening " + urlToLaunch);
      Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlToLaunch));
      browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      this.cordova.getActivity().startActivity(browserIntent);
      callbackContext.success();
      return true;
    } else if (ACTION_CAN_LAUNCH_EVENT.equals(action)) {
      PackageManager manager = getPackageManager();
      Intent intent = new Intent();
      intent.setAction(Intent.ACTION_VIEW);
      intent.setData(Uri.parse(urlToLaunch);
      List<ResolveInfo> infos = manager.queryIntentActivities (intent, PackageManager.GET_RESOLVED_FILTER);
      Log.i(LOG_TAG, "result " + infos);
      Log.i(LOG_TAG, "result " + infos.size());
    } else {
      callbackContext.error("customurllauncher." + action + " is not a supported function. Did you mean '" + ACTION_LAUNCH_EVENT + "'?");
      return false;
    }
  }
}
