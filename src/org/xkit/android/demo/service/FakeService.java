package org.xkit.android.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.text.format.Time;
import android.util.Log;

public class FakeService extends Service {
	private static final String LOG_TAG = "FakeService";

	private FakeBinder mBinder = new FakeBinder();

	@Override
	public IBinder onBind(Intent intent) {
		Log.e(LOG_TAG, "start IBinder~~~");
		return mBinder;
	}

	@Override
	public void onCreate() {
		Log.e(LOG_TAG, "start onCreate~~~");
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.e(LOG_TAG, "start onStart~~~");
		super.onStart(intent, startId);
	}

	@Override
	public void onDestroy() {
		Log.e(LOG_TAG, "start onDestroy~~~");
		super.onDestroy();
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.e(LOG_TAG, "start onUnbind~~~");
		return super.onUnbind(intent);
	}

	public String getSystemTime() {
		Time t = new Time();
		t.setToNow();
		return t.toString();
	}

	public class FakeBinder extends Binder {
		FakeService getService() {
			return FakeService.this;
		}
	}
}
