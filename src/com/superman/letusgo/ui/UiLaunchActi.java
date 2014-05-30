package com.superman.letusgo.ui;

import android.os.Bundle;
import android.view.Window;

import com.superman.letusgo.R;
import com.superman.letusgo.base.BaseUi;

public class UiLaunchActi extends BaseUi {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		toast("in");
		
		this.setContentView(R.layout.activity_launch_actievent);
		toast("success");
	}
	

}
