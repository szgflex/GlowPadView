package com.android.keyguard.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.android.keyguard.widget.GlowPadView;
import com.android.keyguard.widget.GlowPadView.OnTriggerListener;

public class MainActivity extends Activity implements OnTriggerListener {

	private GlowPadView mGlowPadView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.keyguard_glow_pad_container);

		mGlowPadView = (GlowPadView) findViewById(R.id.glow_pad_view);

		mGlowPadView.setOnTriggerListener(this);
	}

	@Override
	public void onGrabbed(View v, int handle) {
	}

	@Override
	public void onReleased(View v, int handle) {
		mGlowPadView.ping();
	}

	@Override
	public void onTrigger(View v, int target) {
		final int resId = mGlowPadView.getResourceIdForTarget(target);
		switch (resId) {
		case R.drawable.ic_lockscreen_unlock:
			Toast.makeText(this, "Unlock selected", Toast.LENGTH_SHORT).show();
			break;
		default:
			// Code should never reach here.
		}
	}

	@Override
	public void onGrabbedStateChange(View v, int handle) {

	}

	@Override
	public void onFinishFinalAnimation() {

	}
}
