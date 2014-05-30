package com.superman.letusgo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.superman.letusgo.R;

public class UiInfo extends Fragment {

	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;
	
	
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_userinfo,
				container, false);
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getFragmentManager());
		mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
		
		

		return rootView;
	}

	public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return new FragmentViewpagerUserinfo();
			case 1:
				return new FragmentViewpagerActievent();
			}
			return null;

		}

		@Override
		public int getCount() {
			return 2;
		}

	}

}
