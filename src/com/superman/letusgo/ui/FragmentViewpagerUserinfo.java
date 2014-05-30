package com.superman.letusgo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.superman.letusgo.R;

public class FragmentViewpagerUserinfo extends Fragment {
	
	private ImageButton mProfileEdit;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(
				R.layout.fragment_viewpager_userinfo,
				container, false);
		mProfileEdit = (ImageButton) rootView
				.findViewById(R.id.profile_edit);
		mProfileEdit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame,
								new FragmentProfileUserinfo())
						.commit();
			}
		});
		return rootView;
	}
}