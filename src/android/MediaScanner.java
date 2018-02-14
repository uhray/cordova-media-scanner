package it.uhray.mediaScanner;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.content.Context;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;

/**
 * Base64ToGallery.java
 *
 * Android implementation of the Base64ToGallery for iOS.
 * Inspirated by Joseph's "Save HTML5 Canvas Image to Gallery" plugin
 * http://jbkflex.wordpress.com/2013/06/19/save-html5-canvas-image-to-gallery-phonegap-android-plugin/
 *
 * @author Vegard Løkken <vegard@headspin.no>
 */
public class MediaScanner extends CordovaPlugin {

  // Consts
  public static final String EMPTY_STR = "";

  @Override
  public boolean execute(String action, JSONArray args,
      CallbackContext callbackContext) throws JSONException {

    String filePath = args.optString(0);

    // isEmpty() requires API level 9
    if (base64.equals(EMPTY_STR)) {
      callbackContext.error("Missing file path");
    }

    scanPhoto(imageFile);
    callbackContext.success(true);
    return true;
  }

  /**
   * Invoke the system's media scanner to add your photo to the Media Provider's database,
   * making it available in the Android Gallery application and to other apps.
   */
  private void scanPhoto(String imageUri) {
    Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
    // Uri contentUri         = Uri.fromFile(imageFile);

    mediaScanIntent.setData(contentUri);
    cordova.getActivity().sendBroadcast(mediaScanIntent);
  }
}
