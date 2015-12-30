package com.gk.sharefile;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;

    /**
     * http://developer.android.com/training/sharing/send.html
     */
    public class ShareFile extends CordovaPlugin {

        @Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
            if (action.equals("share")) {
                String FileURI = args.getString(0);
                String title = args.getString(1);
                String mimetype = args.getString(2);
                this.sharefile(FileURI, title, mimetype, callbackContext);
                return true;
            }
            return false;
        }

        private void sharefile(String uriToFile, String title, String mimetype, CallbackContext callbackContext) {
          try {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_STREAM, uriToFile);
            sendIntent.setType(mimetype);
            cordova.getActivity().startActivity(Intent.createChooser(sendIntent, title));
            callbackContext.success();
            } catch(Error e) {
                callbackContext.error(e.getMessage());
            }
            
        }
    }
