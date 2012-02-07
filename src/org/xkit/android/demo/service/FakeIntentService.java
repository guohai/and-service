package org.xkit.android.demo.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class FakeIntentService extends IntentService {

	// Implicit super constructor IntentService() is undefined for default constructor. Must define an explicit constructor

	private static final String LOG_TAG = "FakeIntentService";
	
	public FakeIntentService() {
		super("FakeIntentService");
	}

	@Override
	public void onCreate() {
		Log.e(LOG_TAG, "start onCreate~~~");
		super.onCreate();
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// we could apply time-consuming code here
		// http://developer.android.com/reference/android/app/IntentService.html
		Log.e(LOG_TAG, "onHandleIntent~~~");
		try {
			Thread.sleep(20 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Log.e(LOG_TAG, "sleep over");
	}
}
