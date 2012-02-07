package org.xkit.android.demo.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AndServiceActivity extends Activity implements OnClickListener {

	private FakeService mService;
	private TextView mTextView;
	private Button startButton;
	private Button stopButton;
	private Button bindButton;
	private Button unbindButton;
	private Context mContext;

	private ServiceConnection mServiceConnection = new ServiceConnection() {
		public void onServiceConnected(ComponentName name, IBinder service) {
			mService = ((FakeService.FakeBinder) service).getService();
			mTextView.setText("I'm from Service :" + mService.getSystemTime());
		}

		public void onServiceDisconnected(ComponentName name) {
		}
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setupViews();
	}

	public void setupViews() {
		mContext = AndServiceActivity.this;
		mTextView = (TextView) findViewById(R.id.text);

		startButton = (Button) findViewById(R.id.startservice);
		stopButton = (Button) findViewById(R.id.stopservice);
		bindButton = (Button) findViewById(R.id.bindservice);
		unbindButton = (Button) findViewById(R.id.unbindservice);

		startButton.setOnClickListener(this);
		stopButton.setOnClickListener(this);
		bindButton.setOnClickListener(this);
		unbindButton.setOnClickListener(this);
	}

	public void onClick(View v) {
		if (v == startButton) {
			Intent i = new Intent();
			i.setClass(AndServiceActivity.this, FakeService.class);
			mContext.startService(i);
		} else if (v == stopButton) {
			Intent i = new Intent();
			i.setClass(AndServiceActivity.this, FakeService.class);
			mContext.stopService(i);
		} else if (v == bindButton) {
			Intent i = new Intent();
			i.setClass(AndServiceActivity.this, FakeService.class);
			mContext.bindService(i, mServiceConnection, BIND_AUTO_CREATE);
		} else {
			mContext.unbindService(mServiceConnection);
		}
	}
}