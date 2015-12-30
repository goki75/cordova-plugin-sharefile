package com.gk.sharefile;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import java.io.File;

    /**
     * http://developer.android.com/training/sharing/send.html
     */
    public class ShareFile extends CordovaPlugin {

        @Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
            if (action.equals("sharefile")) {
                String FilePathURI = args.getString(0);
                String title = args.getString(1);
                String mimetype = args.getString(2);
                this.sharefile(FilePathURI, title, mimetype, callbackContext);
                return true;
            }
            return false;
        }

        private void sharefile(String FilePath, String title, String mimetype, CallbackContext callbackContext) {
          try {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            /**File file = new File(FilePath);*/
            /** shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); */
            /**shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));*/
            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(FilePath));
            shareIntent.setType(mimetype);
            cordova.getActivity().startActivity(Intent.createChooser(shareIntent, title));
            callbackContext.success();
            } catch(Error e) {
                callbackContext.error(e.getMessage());
            }
            
        }
    }
