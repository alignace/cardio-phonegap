package com.alignace.cordova.plugin.cardio;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CardIOPlugin extends CordovaPlugin {

	public static final String TAG = "CardIOPlugin";
	public static final String SCAN = "scan";

	CallbackContext callbackContext;

	public static JSONArray mCreditcardNumber = null;
	public static Boolean expiry;
	public static Boolean cvv;
	public static Boolean zip;
	public static Boolean confirm;
	public static Boolean hideLogo;
	public static Boolean suppressManual;

	private Context getApplicationContext() {
		return this.cordova.getActivity().getApplicationContext();
	}

	@Override
	public boolean execute(String action, JSONArray data,
			CallbackContext callbackContext) {
		boolean result = false;
		this.callbackContext = callbackContext;

		Log.v(TAG, "execute: action=" + action);

		if (SCAN.equals(action)) {

			Log.v(TAG, "execute: data=" + data.toString());

			try {
				// set configurations
				JSONObject config = data.getJSONObject(0);

				expiry = config.getBoolean("expiry");
				cvv = config.getBoolean("cvv");
				zip = config.getBoolean("zip");
				confirm = config.getBoolean("confirm");
				hideLogo = config.getBoolean("hideLogo");
				suppressManual = config.getBoolean("suppressManual");

				Intent scanIntent = new Intent(cordova.getActivity(),
						CardIOMain.class);
				cordova.getActivity().startActivity(scanIntent);

				result = true;

			} catch (JSONException e) {
				PluginResult res = new PluginResult(
						PluginResult.Status.JSON_EXCEPTION);
				callbackContext.sendPluginResult(res);
				result = false;
			}
		}

		return result;

	}

	@Override
	public void onResume(boolean multitasking) {
		super.onResume(multitasking);

		// send plugin result if success
		JSONArray mImagepath = mCreditcardNumber;
		if (mImagepath != null) {
			PluginResult cardData = new PluginResult(PluginResult.Status.OK,
					mCreditcardNumber);
			cardData.setKeepCallback(false);
			callbackContext.sendPluginResult(cardData);
			mCreditcardNumber = null;
		} else {
			PluginResult cardData = new PluginResult(
					PluginResult.Status.NO_RESULT);
			cardData.setKeepCallback(false);
			callbackContext.sendPluginResult(cardData);
		}
	}

}
